PR .= ".2"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://tar-1.24-xattrs.patch"

inherit enable-selinux
