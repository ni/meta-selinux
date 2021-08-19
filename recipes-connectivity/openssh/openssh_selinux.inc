inherit enable-selinux enable-audit

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG[selinux] = "--with-selinux,--without-selinux,libselinux"
PACKAGECONFIG[audit] = "--with-audit=linux,--without-audit,audit"
