include selinux_20170804.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "9424b93fd6efd853b9360f29265c5aa3"
SRC_URI[sha256sum] = "d69d3bd8ec901a3bd5adf2be2fb47fb1a685ed73066ab482e7e505371a48f9e7"

SRC_URI += "file://0001-src-Makefile-fix-includedir-in-libsepol.pc.patch"
