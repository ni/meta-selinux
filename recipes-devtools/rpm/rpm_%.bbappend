FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

inherit with-selinux
PACKAGECONFIG[selinux] = "${WITH_SELINUX},${WITHOUT_SELINUX},libsemanage,"
