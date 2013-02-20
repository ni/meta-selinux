PR .= ".3"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://fix-libmount_la_DEPENDENCIES.patch \
           "

inherit with-selinux
