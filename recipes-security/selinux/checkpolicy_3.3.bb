SUMMARY = "SELinux policy compiler"
DESCRIPTION = "\
This package contains checkpolicy, the SELinux policy compiler. Only \
required for building policies. It uses libsepol to generate the \
binary policy. checkpolicy uses the static libsepol since it deals \
with low level details of the policy that have not been \
encapsulated/abstracted by a proper shared library interface."
SECTION = "base"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=393a5ca445f6965873eca0259a17f833"

require selinux_common.inc

DEPENDS += "libsepol bison-native flex-native"

EXTRA_OEMAKE += "LEX='flex'"
EXTRA_OEMAKE += "LIBSEPOLA=${STAGING_LIBDIR}/libsepol.a"

S = "${WORKDIR}/git/checkpolicy"

do_install:append() {
    install test/dismod ${D}/${bindir}/sedismod
    install test/dispol ${D}/${bindir}/sedispol
}

BBCLASSEXTEND = "native"
