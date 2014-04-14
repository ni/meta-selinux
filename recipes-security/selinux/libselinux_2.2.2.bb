PR = "r99"

include selinux_20131030.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

SRC_URI[md5sum] = "55026eb4654c4f732a27c191b39bebaf"
SRC_URI[sha256sum] = "30ab363416806da907b86b97f1d31c252473e3200358bb1570f563c8312b5a3e"

SRC_URI += "\
        file://libselinux-drop-Wno-unused-but-set-variable.patch \
        file://libselinux-make-O_CLOEXEC-optional.patch \
        file://libselinux-make-SOCK_CLOEXEC-optional.patch \
        file://libselinux-define-FD_CLOEXEC-as-necessary.patch \
        "
