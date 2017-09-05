include selinux_20170804.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI[md5sum] = "65311b66ae01f7b7ad7c2ea7401b68ed"
SRC_URI[sha256sum] = "0a1b8a4a323b854981c6755ff025fe98a0f1cff307f109abb260f0490f13e4f4"

SRC_URI += "\
	file://policycoreutils-loadpolicy-symlink.patch \
	"
