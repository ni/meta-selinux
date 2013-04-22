PR = "r0"

include selinux_20120924.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "56fa100ed85d7f06bd92f2892d92b3b0"
SRC_URI[sha256sum] = "63eedd2e435658eedb14cf5eb803468b701f4a2404f1a4af4ab52858e9c068f0"

SRC_URI += "file://libsepol-Change-ranlib-for-cross-compiling.patch"
