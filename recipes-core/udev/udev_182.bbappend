PR .= ".2"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += "${@base_contains('DISTRO_FEATURES', 'selinux', 'libselinux', '', d)}"

EXTRA_OECONF += "${@base_contains('DISTRO_FEATURES', 'selinux', '--with-selinux', '--without-selinux', d)}"
