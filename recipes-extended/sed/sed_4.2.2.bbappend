PR .= ".2"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "file://sed-selinux-fix.patch"

inherit selinux

DEPENDS += "${LIBSELINUX}"
