PR .= ".2"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://pstree-compiles-with-SE-Linux.patch"

inherit enable-selinux
