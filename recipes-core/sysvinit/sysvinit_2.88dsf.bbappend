FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

B = "${S}"

SRC_URI += "file://sysvinit-fix-is_selinux_enabled.patch"

DEPENDS += "${@base_contains('DISTRO_FEATURES', 'selinux', 'libselinux', '', d)}"

EXTRA_OEMAKE += "${@base_contains('DISTRO_FEATURES', 'selinux', 'WITH_SELINUX=\"yes\"', '', d)}"

PR .= ".1"

