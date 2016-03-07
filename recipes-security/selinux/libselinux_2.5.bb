include selinux_20160223.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

SRC_URI[md5sum] = "d1399f5c2fd2fbe0e9603d5143b30367"
SRC_URI[sha256sum] = "94c9e97706280bedcc288f784f67f2b9d3d6136c192b2c9f812115edba58514f"

SRC_URI += "\
        file://libselinux-drop-Wno-unused-but-set-variable.patch \
        file://libselinux-make-O_CLOEXEC-optional.patch \
        file://libselinux-make-SOCK_CLOEXEC-optional.patch \
        file://libselinux-define-FD_CLOEXEC-as-necessary.patch \
        file://libselinux-only-mount-proc-if-necessary.patch \
        file://0001-src-Makefile-fix-includedir-in-libselinux.pc.patch \
        "
