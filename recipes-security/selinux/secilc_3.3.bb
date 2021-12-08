SUMMARY = "SELinux Common Intermediate Language (CIL) compiler"
DESCRIPTION = "\
This package contains secilc, the SELinux Common Intermediate \
Language (CIL) compiler."
SECTION = "base"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=c7e802b9a3b0c2c852669864c08b9138"

require selinux_common.inc

DEPENDS += "libsepol xmlto-native"

S = "${WORKDIR}/git/secilc"

BBCLASSEXTEND = "native"
