PR = "r0"

include selinux_20130423.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "980964224683fa29d4ed65beb94b56ee"
SRC_URI[sha256sum] = "290d17f583635a4a5d8a2141511272adf0571c4205cdea38b5a68df20d58a70b"

SRC_URI += "file://libsepol-Change-ranlib-for-cross-compiling.patch"
