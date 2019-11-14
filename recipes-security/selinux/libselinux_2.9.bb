require selinux_20190315.inc
require ${BPN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

SRC_URI[md5sum] = "bb449431b6ed55a0a0496dbc366d6e31"
SRC_URI[sha256sum] = "1bccc8873e449587d9a2b2cf253de9b89a8291b9fbc7c59393ca9e5f5f4d2693"

SRC_URI += "\
        file://libselinux-drop-Wno-unused-but-set-variable.patch \
        file://libselinux-make-O_CLOEXEC-optional.patch \
        file://libselinux-make-SOCK_CLOEXEC-optional.patch \
        file://libselinux-define-FD_CLOEXEC-as-necessary.patch \
        "
