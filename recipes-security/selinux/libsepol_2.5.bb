include selinux_20160223.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "5b18e0e1e50bdf648c2c42241c42052c"
SRC_URI[sha256sum] = "2bdeec56d0a08b082b93b40703b4b3329cc5562152f7254d8f6ef6b56afe850a"

SRC_URI += "file://0001-src-Makefile-fix-includedir-in-libsepol.pc.patch"
