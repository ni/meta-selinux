PR = "r0"

include selinux_20130423.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

SRC_URI[md5sum] = "32bf7b5182977a8a9248a1eeefe49a22"
SRC_URI[sha256sum] = "57aad47c06b7ec18a76e8d9870539277a84cb40109cfdcf70ed3260bdb04447a"

SRC_URI += "\
        file://libselinux-fix-init-load-policy.patch \
        file://libselinux-pcre-link-order.patch \
        file://libselinux-drop-Wno-unused-but-set-variable.patch \
        "
