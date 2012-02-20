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

include selinux_20120216.inc

SRC_URI[md5sum] = "fefdede2815cdd2ba8b68599fef1f257"
SRC_URI[sha256sum] = "8bbbc36b7d375edff891503932da93e37553f0dd7bdceded7ce9a45c80bec3d1"

DEPENDS += "libsepol libselinux libsemanage libcap-ng libcgroup"
DEPENDS += "${@base_contains('DISTRO_FEATURES', 'pam', 'libpam audit', '', d)}"

RDEPENDS_${PN} += "\
	libselinux-python \
	libsemanage-python \
	sepolgen \
	"
RDEPENDS_${PN} += "\
	python \
	python-unixadmin \
	python-shell \
	python-crypt \
	python-subprocess \
	python-syslog \
	python-textutils \
	python-IPy \
	"
#RDEPENDS_${PN} += "setools"

RDEPENDS_${PN}_virtclass-native = "python-native sepolgen-native"


PACKAGES =+ "${PN}-python ${PN}-sandbox"
FILES_${PN}-python = "${libdir}/python${PYTHON_BASEVERSION}/site-packages/*"
FILES_${PN}-sandbox = "${datadir}/sandbox/*"
FILES_${PN}-sandbox += "${bindir}/sandbox"
FILES_${PN}-sandbox += "${sbindir}/seunshare"

CFLAGS_append = " -Wno-error=format-security"
EXTRA_OEMAKE += "${@base_contains('DISTRO_FEATURES', 'pam', 'PAMH=y AUDITH=y', '', d)}"
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
