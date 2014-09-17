SECTION = "base"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=393a5ca445f6965873eca0259a17f833"

# Specific config files for Poky
SRC_URI += "file://customizable_types \
            file://setrans-mls.conf \
            file://setrans-mcs.conf \
	   "

S = "${WORKDIR}/refpolicy"

FILES_${PN} = " \
	${sysconfdir}/selinux/${POLICY_NAME}/ \
	${@bb.utils.contains('DISTRO_FEATURES', 'compressed_policy', '${datadir}/selinux/${POLICY_NAME}/*.pp.bz2', '${datadir}/selinux/${POLICY_NAME}/*.pp', d)} \
	"
FILES_${PN}-dev =+ "${datadir}/selinux/${POLICY_NAME}/include/"

DEPENDS += "checkpolicy-native policycoreutils-native m4-native"
RDEPENDS_${PN} += "selinux-config"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit pythonnative

PARALLEL_MAKE = ""

POLICY_NAME ?= "${POLICY_TYPE}"
POLICY_DISTRO ?= "redhat"
POLICY_UBAC ?= "n"
POLICY_UNK_PERMS ?= "allow"
POLICY_DIRECT_INITRC ?= "n"
POLICY_MONOLITHIC ?= "n"
POLICY_CUSTOM_BUILDOPT ?= ""
POLICY_QUIET ?= "y"
POLICY_MLS_SENS ?= "16"
POLICY_MLS_CATS ?= "1024"
POLICY_MCS_CATS ?= "1024"

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

prepare_policy_store () {
	oe_runmake 'DESTDIR=${D}' 'prefix=${D}${prefix}' install

	# Prepare to create policy store
	mkdir -p ${D}${sysconfdir}/selinux/
	mkdir -p ${D}${sysconfdir}/selinux/${POLICY_NAME}/policy
	mkdir -p ${D}${sysconfdir}/selinux/${POLICY_NAME}/modules/active/modules
	mkdir -p ${D}${sysconfdir}/selinux/${POLICY_NAME}/contexts/files
	touch ${D}${sysconfdir}/selinux/${POLICY_NAME}/contexts/files/file_contexts.local
	if  ${@bb.utils.contains('DISTRO_FEATURES','compressed_policy','true','false',d)}; then
		for i in ${D}${datadir}/selinux/${POLICY_NAME}/*.pp; do
			bzip2 $i
			if [ "`basename $i`" != "base.pp" ]; then
				cp ${i}.bz2 ${D}${sysconfdir}/selinux/${POLICY_NAME}/modules/active/modules/`basename $i`
			else
				cp ${i}.bz2 ${D}${sysconfdir}/selinux/${POLICY_NAME}/modules/active/`basename $i`
			fi
		done
	else
		bzip2 -c ${D}${datadir}/selinux/${POLICY_NAME}/base.pp  >\
			${D}${sysconfdir}/selinux/${POLICY_NAME}/modules/active/base.pp
		for i in ${D}${datadir}/selinux/${POLICY_NAME}/*.pp; do
			if [ "`basename $i`" != "base.pp" ]; then
				bzip2 -c $i > ${D}${sysconfdir}/selinux/${POLICY_NAME}/modules/active/modules/`basename $i`;
			fi
		done
	fi
}

rebuild_policy () {
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

policy-version = 28
EOF

	# Create policy store and build the policy
	semodule -p ${D} -s ${POLICY_NAME} -n -B
	rm -f ${D}${sysconfdir}/selinux/semanage.conf
}

install_misc_files () {
	cat ${WORKDIR}/customizable_types >> \
		${D}${sysconfdir}/selinux/${POLICY_NAME}/contexts/customizable_types

	# install setrans.conf for mls/mcs policy
	if [ -f ${WORKDIR}/setrans-${POLICY_TYPE}.conf ]; then
		install -m 0644 ${WORKDIR}/setrans-${POLICY_TYPE}.conf \
			${D}${sysconfdir}/selinux/${POLICY_NAME}/setrans.conf
	fi

	# install policy headers
	oe_runmake 'DESTDIR=${D}' 'prefix=${D}${prefix}' install-headers

	# Fix symbol link policy.kern
	link_path=`readlink -f ${D}${sysconfdir}/selinux/${POLICY_NAME}/modules/active/policy.kern`
	ln -sf ../../policy/`basename $link_path` ${D}${sysconfdir}/selinux/${POLICY_NAME}/modules/active/policy.kern
}

do_install () {
	prepare_policy_store
	rebuild_policy
	install_misc_files
}
