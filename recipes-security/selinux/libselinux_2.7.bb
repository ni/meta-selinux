include selinux_20170804.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

SRC_URI[md5sum] = "1d48ee4e9fadd76794d70c806b69ba7d"
SRC_URI[sha256sum] = "d0fec0769b3ad60aa7baf9b9a4b7a056827769dc2dadda0dc0eb59b3d1c18c57"

SRC_URI += "\
        file://libselinux-drop-Wno-unused-but-set-variable.patch \
        file://libselinux-make-O_CLOEXEC-optional.patch \
        file://libselinux-make-SOCK_CLOEXEC-optional.patch \
        file://libselinux-define-FD_CLOEXEC-as-necessary.patch \
        file://0001-src-Makefile-fix-includedir-in-libselinux.pc.patch \
        "
