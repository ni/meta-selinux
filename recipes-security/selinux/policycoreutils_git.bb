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

include selinux_git.inc

SRCREV = "339f8079d7b9dd1e0b0138e2d096dc7c60b2092e"
PV = "2.1.10+git${SRCPV}"

DEPENDS += "libsepol libselinux libsemanage"
DEPENDS_${BPN} += "libcap-ng libcgroup"
DEPENDS_${BPN} += "${@base_contains('DISTRO_FEATURES', 'pam', 'libpam audit', '', d)}"

RDEPENDS_${BPN} += "\
	libselinux-python \
	libsemanage-python \
	sepolgen \
	"
RDEPENDS_${BPN} += "\
	python \
	python-unixadmin \
	python-shell \
	python-crypt \
	python-subprocess \
	python-syslog \
	python-textutils \
	python-IPy \
	"
RDEPENDS_${BPN} += "setools"


PACKAGES =+ "${PN}-python ${PN}-sandbox"
FILES_${PN}-python = "${libdir}/python${PYTHON_BASEVERSION}/site-packages/*"
FILES_${PN}-sandbox = "${datadir}/sandbox/*"
FILES_${PN}-sandbox += "${bindir}/sandbox"
FILES_${PN}-sandbox += "${sbindir}/seunshare"

CFLAGS_append = " -Wno-error=format-security"
AUDITH="`ls ${STAGING_INCDIR}/libaudit.h >/dev/null 2>&1 && echo /usr/include/libaudit.h `"
PAMH="`ls ${STAGING_INCDIR}/security/pam_appl.h >/dev/null 2>&1 && echo /usr/include/security/pam_appl.h `"
EXTRA_OEMAKE += "PAMH=${PAMH} AUDITH=${AUDITH} INOTIFYH=n"
EXTRA_OEMAKE += "PREFIX=${D}"

BBCLASSEXTEND = "native"

PCU_NATIVE_CMDS = "setfiles semodule_package semodule semodule_link semodule_expand semodule_deps"

do_compile_virtclass-native() {
	for PCU_CMD in ${PCU_NATIVE_CMDS} ; do
		oe_runmake -C $PCU_CMD \
			INCLUDEDIR='${STAGING_INCDIR}' \
			LIBDIR='${STAGING_LIBDIR}'
	done
}

do_install_virtclass-native() {
	for PCU_CMD in ${PCU_NATIVE_CMDS} ; do
	     oe_runmake -C $PCU_CMD install \
			DESTDIR="${D}" \
			PREFIX="${D}/${prefix}" \
			SBINDIR="${D}/${base_sbindir}"
	done
}
