FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit enable-selinux
PACKAGECONFIG[selinux] = "--enable-selinux,--disable-selinux,libselinux"
