include selinux_20140506.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

SRC_URI[md5sum] = "b11d4d95ef4bde732dbc8462df57a1e5"
SRC_URI[sha256sum] = "0b1e0b43ecd84a812713d09564019b08e7c205d89072b5cbcd07b052cd8e77b2"

SRC_URI += "\
        file://libselinux-drop-Wno-unused-but-set-variable.patch \
        file://libselinux-make-O_CLOEXEC-optional.patch \
        file://libselinux-make-SOCK_CLOEXEC-optional.patch \
        file://libselinux-define-FD_CLOEXEC-as-necessary.patch \
        file://libselinux-get-pywrap-depends-on-selinux.py.patch \
        "
