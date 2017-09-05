inherit selinux

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += "${@target_selinux(d, 'file://fix-ptest-failures-when-selinux-enabled.patch')}"
