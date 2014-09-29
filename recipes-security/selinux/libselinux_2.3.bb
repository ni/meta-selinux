include selinux_20140506.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

SRC_URI[md5sum] = "d27e249ad8450e7182203134cf4d85e2"
SRC_URI[sha256sum] = "03fe2baa7ceeea531a64fd321b44ecf09a55f3af5ef66a58a4135944f34e9851"

SRC_URI += "\
        file://libselinux-drop-Wno-unused-but-set-variable.patch \
        file://libselinux-make-O_CLOEXEC-optional.patch \
        file://libselinux-make-SOCK_CLOEXEC-optional.patch \
        file://libselinux-define-FD_CLOEXEC-as-necessary.patch \
        "
