SUMMARY = "SELinux policy compiler"
DESCRIPTION = "SELinux policy compiler"
SECTION = "base"
PR = "r1"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

include selinux_git.inc

SRCREV = "339f8079d7b9dd1e0b0138e2d096dc7c60b2092e"
S = "${WORKDIR}/git/checkpolicy"
DEPENDS += "libsepol libselinux flex-native"

EXTRA_OEMAKE += "PREFIX=${D}" 
EXTRA_OEMAKE += "LEX='flex'"

BBCLASSEXTEND = "native"

do_compile() {
	oe_runmake checkpolicy checkmodule \
            INCLUDEDIR='${STAGING_INCDIR}' \
            LIBDIR='${STAGING_LIBDIR}'
	oe_runmake -C test \
            INCLUDEDIR='${STAGING_INCDIR}' \
            LIBDIR='${STAGING_LIBDIR}'
}

do_install_append() {
	install test/dismod ${D}/${bindir}/sedismod
	install test/dispol ${D}/${bindir}/sedispol
}

