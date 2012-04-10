SECTION = "base"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=393a5ca445f6965873eca0259a17f833"

S = "${WORKDIR}/refpolicy"

FILES_${PN} = "${sysconfdir}/selinux/${POLICY_NAME}/ \
	${datadir}/selinux/${POLICY_NAME}/"

DEPENDS += "checkpolicy-native policycoreutils-native python-native m4-native"

inherit autotools

PARALLEL_MAKE = ""

EXTRA_OEMAKE += "NAME=${POLICY_NAME} \
	TYPE=${POLICY_TYPE} \
	DISTRO=${POLICY_DISTRO} \
	UNK_PERMS=${POLICY_UNK_PERMS} \
	DIRECT_INITRC=${POLICY_DIRECT_INITRC} \
	MONOLITHIC=${POLICY_MONOLITHIC} \
	CUSTOM_BUILDOPT=${POLICY_CUSTOM_BUILDOPT} \
	QUIET=${POLICY_QUIET} \
	MLS_SENS=${POLICY_MLS_SENS} \
	MLS_CATS=${POLICY_MLS_CATS} \
	MCS_CATS=${POLICY_MCS_CATS}"

EXTRA_OEMAKE += "tc_usrbindir=${STAGING_BINDIR_NATIVE}"
EXTRA_OEMAKE += "OUTPUT_POLICY=`${STAGING_BINDIR_NATIVE}/checkpolicy -V | cut -d' ' -f1`"
EXTRA_OEMAKE += "CC='${BUILD_CC}' CFLAGS='${BUILD_CFLAGS}'"

do_compile() {
	oe_runmake conf
	oe_runmake policy
}

do_install() {
	oe_runmake install \
		DESTDIR=${D}

	# Prepare to create policy store
	mkdir -p ${D}/etc/selinux/
	cat <<-EOF > ${D}/etc/selinux/semanage.conf
module-store = direct
[setfiles]
path = ${STAGING_DIR_NATIVE}${base_sbindir_native}/setfiles
args = -q -c \$@ \$<
[end]
EOF
	mkdir -p ${D}/etc/selinux/${POLICY_NAME}/policy
	mkdir -p ${D}/etc/selinux/${POLICY_NAME}/modules/active/modules
	mkdir -p ${D}/etc/selinux/${POLICY_NAME}/contexts/files
	bzip2 -c ${D}/usr/share/selinux/${POLICY_NAME}/base.pp  > \
		${D}/etc/selinux/${POLICY_NAME}/modules/active/base.pp
	for i in ${D}/usr/share/selinux/${POLICY_NAME}/*.pp; do
		if [ "`basename $i`" != "base.pp" ]; then
			bzip2 -c $i > ${D}/etc/selinux/${POLICY_NAME}/modules/active/modules/`basename $i`;
		fi
	done

	# Create policy store and build the policy
	semodule -p ${D} -s ${POLICY_NAME} -n -B
	rm -f ${D}/etc/selinux/semanage.conf
}
