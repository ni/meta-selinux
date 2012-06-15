DEFAULT_POLICY = "mls"

SUMMARY = "SELinux configuration"
DESCRIPTION = "\
This is the configuration files for SELinux on WRLinux system.  \
"

SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

CONFFILES_${PN} += "${sysconfdir}/selinux/config"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install () {
	echo "\
# This file controls the state of SELinux on the system.
# SELINUX= can take one of these three values:
#     enforcing - SELinux security policy is enforced.
#     permissive - SELinux prints warnings instead of enforcing.
#     disabled - No SELinux policy is loaded.
SELINUX=enforcing
# SELINUXTYPE= can take one of these two values:
#     standard - Standard Security protection.
#     mls - Multi Level Security protection.
SELINUXTYPE=${DEFAULT_POLICY}
" > ${WORKDIR}/config
	install -d ${D}/${sysconfdir}/selinux
	install -m 0644 ${WORKDIR}/config ${D}/${sysconfdir}/selinux/
}

