PR = "r0"

include selinux_20120924.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

SRC_URI[md5sum] = "73270f384a032fad34b5fe075fa05ce2"
SRC_URI[sha256sum] = "8dad879380e0ce1e4ab67195a08f6052c1396493bcb12fe92a033f49f7dbca9e"

SRC_URI += "file://libselinux-fix-init-load-policy.patch \
	file://libselinux-pcre-link-order.patch"
