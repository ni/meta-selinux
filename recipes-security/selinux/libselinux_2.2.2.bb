PR = "r99"

include selinux_20131030.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

SRC_URI[md5sum] = "c13ea5de171f21fee399abfd4aef9481"
SRC_URI[sha256sum] = "cc8354d67d7bef11fb2a03d23e788c6f4e8510b6760c3778dc7baf6dcfa97539"

SRC_URI += "\
        file://libselinux-drop-Wno-unused-but-set-variable.patch \
        file://libselinux-make-O_CLOEXEC-optional.patch \
        file://libselinux-make-SOCK_CLOEXEC-optional.patch \
        file://libselinux-define-FD_CLOEXEC-as-necessary.patch \
        "
