SUMMARY = "SELinux policy core utilities"
DESCRIPTION = "policycoreutils contains the policy core utilities that are required \
for basic operation of a SELinux system.  These utilities include \
load_policy to load policies, setfiles to label filesystems, newrole \
to switch roles, and run_init to run /etc/init.d scripts in the proper \
context."
SECTION = "base"
PR = "r1"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

include selinux.inc

SRC_URI += "file://makefiles.patch"

SRC_URI[md5sum] = "f418384ea5bc57080a6ace843646aba9"
SRC_URI[sha256sum] = "6199b07fd4280e455ea05933cee510b5e09ad3f60b0544382231fe05b787d3f3"

DEPENDS += "libsepol libselinux libsemanage libcap-ng"
DEPENDS += "${@base_contains('DISTRO_FEATURES', 'pam', 'libpam audit', '', d)}"

RDEPENDS_${PN} += "sepolgen"

EXTRA_OEMAKE += "PREFIX='$(DESTDIR)${prefix}' BASE_SBINDIR='$(DESTDIR)${base_sbindir}' SBINDIR='$(DESTDIR)${sbindir}'"
EXTRA_OEMAKE += "BINDIR='$(DESTDIR)${bindir}' MANDIR='$(DESTDIR)/${mandir}' LOCALEDIR='$(DESTDIR)/${datadir}/locale'"
EXTRA_OEMAKE += "ETCDIR='$(DESTDIR)${sysconfdir}' SHAREDIR='$(DESTDIR)${datadir}'"
EXTRA_OEMAKE += "INITDIR='$(DESTDIR)${sysconfdir}/init.d'"
EXTRA_OEMAKE += "INCLUDEDIR='${STAGING_INCDIR}' LIBDIR='${STAGING_LIBDIR}'"
# Main Makefile
EXTRA_OEMAKE += "INOTIFYH=y"
# newrole/Makefile
# Options: PAMH, AUDITH, AUDIT_LOG_PRIV, NAMESPACE_PRIV, LSPP_PRIV
EXTRA_OEMAKE += "${@base_contains('DISTRO_FEATURES', 'pam', 'PAMH=y AUDITH=y', '', d)}"
# restorecond/Makefile
# AUTOSTARTDIR ?= $(DESTDIR)/etc/xdg/autostart  DBUSSERVICEDIR ?= $(DESTDIR)/usr/share/dbus-1/services
# SELINUXDIR ?= $(DESTDIR)/etc/selinux
# semanage/Makefile
EXTRA_OEMAKE += "PYLIBVER='python${PYTHON_BASEVERSION}'"

do_compile() {
	oe_runmake all
}

do_install() {
	oe_runmake DESTDIR=${D} install

	if [ "${base_sbindir}" != "${sbindir}" ]; then
	   mv ${D}${base_sbindir}/fixfiles ${D}${sbindir}/fixfiles
	fi

	rm ${D}${datadir}/sandboxX.sh
}
