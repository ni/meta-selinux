require selinux_20191204.inc
require ${BPN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

SRC_URI[md5sum] = "b387a66f087b6d97713570e85ec89d89"
SRC_URI[sha256sum] = "2ea2b30f671dae9d6b1391cbe8fb2ce5d36a3ee4fb1cd3c32f0d933c31b82433"

SRC_URI += "\
        file://libselinux-drop-Wno-unused-but-set-variable.patch \
        file://libselinux-make-O_CLOEXEC-optional.patch \
        file://libselinux-make-SOCK_CLOEXEC-optional.patch \
        file://libselinux-define-FD_CLOEXEC-as-necessary.patch \
        file://0001-Fix-building-against-musl-and-uClibc-libc-libraries.patch \
        "
