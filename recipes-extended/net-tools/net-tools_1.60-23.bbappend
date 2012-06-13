PR .= ".1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://netstat-selinux-support.patch"

DEPENDS += "${@base_contains('DISTRO_FEATURES', 'selinux', 'libselinux', '', d)}"

EXTRA_OEMAKE += "${@base_contains('DISTRO_FEATURES', 'selinux', 'HAVE_SELINUX=1', 'HAVE_SELINUX=0', d)}"
