PRINC = "4"

SECTION = "base"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=393a5ca445f6965873eca0259a17f833"

# Specific config files for Poky
SRC_URI += "file://customizable_types \
	   "

S = "${WORKDIR}/refpolicy"

FILES_${PN} = "${sysconfdir}/selinux/${POLICY_NAME}/ \
	${datadir}/selinux/${POLICY_NAME}/*.pp"
FILES_${PN}-dev =+ "${datadir}/selinux/${POLICY_NAME}/include/"

DEPENDS += "checkpolicy-native policycoreutils-native m4-native"
RDEPENDS_${PN} += "selinux-config"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools pythonnative

PARALLEL_MAKE = ""

EXTRA_OEMAKE += "NAME=${POLICY_NAME} \
	TYPE=${POLICY_TYPE} \
	DISTRO=${POLICY_DISTRO} \
	UBAC=${POLICY_UBAC} \
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
EXTRA_OEMAKE += "CC='${BUILD_CC}' CFLAGS='${BUILD_CFLAGS}' PYTHON='${PYTHON}'"

do_compile() {
	oe_runmake conf
	oe_runmake policy
}

do_install() {
	oe_runmake install \
		DESTDIR=${D}

	# Prepare to create policy store
	mkdir -p ${D}${sysconfdir}/selinux/
	cat <<-EOF > ${D}${sysconfdir}/selinux/semanage.conf
module-store = direct
[setfiles]
path = ${STAGING_DIR_NATIVE}${base_sbindir_native}/setfiles
args = -q -c \$@ \$<
[end]
[sefcontext_compile]
path = ${STAGING_DIR_NATIVE}${sbindir_native}/sefcontext_compile
args = \$@
[end]
EOF
	mkdir -p ${D}${sysconfdir}/selinux/${POLICY_NAME}/policy
	mkdir -p ${D}${sysconfdir}/selinux/${POLICY_NAME}/modules/active/modules
	mkdir -p ${D}${sysconfdir}/selinux/${POLICY_NAME}/contexts/files
	touch ${D}${sysconfdir}/selinux/${POLICY_NAME}/contexts/files/file_contexts.local
	bzip2 -c ${D}${datadir}/selinux/${POLICY_NAME}/base.pp  > \
		${D}${sysconfdir}/selinux/${POLICY_NAME}/modules/active/base.pp
	for i in ${D}${datadir}/selinux/${POLICY_NAME}/*.pp; do
		if [ "`basename $i`" != "base.pp" ]; then
			bzip2 -c $i > ${D}${sysconfdir}/selinux/${POLICY_NAME}/modules/active/modules/`basename $i`;
		fi
	done

	# Create policy store and build the policy
	semodule -p ${D} -s ${POLICY_NAME} -n -B
	rm -f ${D}${sysconfdir}/selinux/semanage.conf

	cat ${WORKDIR}/customizable_types >> \
		${D}${sysconfdir}/selinux/${POLICY_NAME}/contexts/customizable_types

	# install policy headers
	oe_runmake install-headers DESTDIR=${D}
}
