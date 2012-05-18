SUMMARY = "SELinux policy compiler"
DESCRIPTION = "\
This package contains checkpolicy, the SELinux policy compiler. Only \
required for building policies. It uses libsepol to generate the \
binary policy. checkpolicy uses the static libsepol since it deals \
with low level details of the policy that have not been \
encapsulated/abstracted by a proper shared library interface."

SECTION = "base"
PR = "r1"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"
DEFAULT_PREFERENCE = "-1"

include selinux_git.inc

SRCREV = "339f8079d7b9dd1e0b0138e2d096dc7c60b2092e"
PV = "2.1.8+git${SRCPV}"

DEPENDS += "libsepol libselinux flex-native"

EXTRA_OEMAKE += "PREFIX=${D}" 
EXTRA_OEMAKE += "LEX='flex'"

BBCLASSEXTEND = "native"

do_install_append() {
	install test/dismod ${D}/${bindir}/sedismod
	install test/dispol ${D}/${bindir}/sedispol
}

