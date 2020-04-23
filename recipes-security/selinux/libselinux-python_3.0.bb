SELINUX_RELEASE = "20191204"

SRC_URI = "https://github.com/SELinuxProject/selinux/releases/download/${SELINUX_RELEASE}/libselinux-${PV}.tar.gz"

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
        file://0001-Makefile-fix-python-modules-install-path-for-multili.patch \
        file://0001-Do-not-use-PYCEXT-and-rely-on-the-installed-file-nam.patch \
        "
S = "${WORKDIR}/libselinux-${PV}"
