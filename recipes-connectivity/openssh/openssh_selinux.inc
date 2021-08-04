inherit with-selinux

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# There is no distro feature just for audit.
PACKAGECONFIG:append = " audit"

PACKAGECONFIG[audit] = "--with-audit=linux,--without-audit,audit,"

