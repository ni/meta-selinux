PR = "r3"

include selinux_20120216.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

SRC_URI[md5sum] = "8ea0548dd65e9479b357ba1447f89221"
SRC_URI[sha256sum] = "749d4b39c80aa9df8247b8b3187ab72442c0dbad6e70bf312e25052bd4e7063f"

SRC_URI += "file://libselinux-fix-init-load-policy.patch"
