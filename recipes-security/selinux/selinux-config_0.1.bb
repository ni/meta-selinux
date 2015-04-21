DEFAULT_POLICY = "mls"
DEFAULT_ENFORCING = "enforcing"

SUMMARY = "SELinux configuration"
DESCRIPTION = "\
This is the configuration files for SELinux on WRLinux system.  \
"

SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r3"

S = "${WORKDIR}"

SRC_URI = "file://selinux-init.sh"

inherit update-rc.d

INITSCRIPT_NAME = "0selinux-init"
INITSCRIPT_PARAMS = "start 00 S ."

CONFFILES_${PN} += "${sysconfdir}/selinux/config \
	${sysconfdir}/init.d/0selinux-init \
	"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install () {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/selinux-init.sh ${D}${sysconfdir}/init.d/0selinux-init

	echo "\
# This file controls the state of SELinux on the system.
# SELINUX= can take one of these three values:
#     enforcing - SELinux security policy is enforced.
#     permissive - SELinux prints warnings instead of enforcing.
#     disabled - No SELinux policy is loaded.
SELINUX=${DEFAULT_ENFORCING}
# SELINUXTYPE= can take one of these two values:
#     standard - Standard Security protection.
#     mls - Multi Level Security protection.
SELINUXTYPE=${DEFAULT_POLICY}
" > ${WORKDIR}/config
	install -d ${D}/${sysconfdir}/selinux
	install -m 0644 ${WORKDIR}/config ${D}/${sysconfdir}/selinux/
}

sysroot_stage_all_append () {
	sysroot_stage_dir ${D}${sysconfdir} ${SYSROOT_DESTDIR}${sysconfdir}
}
