PR = "r0"

include selinux_20131030.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

SRC_URI[md5sum] = "d82beab880749a017f2737e6687fec30"
SRC_URI[sha256sum] = "e9dc64216543a7283d786f623ac28e8867f8794138e7deba474a3aa8d02dce33"

SRC_URI += "\
        file://libselinux-drop-Wno-unused-but-set-variable.patch \
        file://libselinux-make-O_CLOEXEC-optional.patch \
        file://libselinux-make-SOCK_CLOEXEC-optional.patch \
        file://libselinux-define-FD_CLOEXEC-as-necessary.patch \
        "
