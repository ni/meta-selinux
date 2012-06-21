PR .= ".1"

DEPENDS += "${@base_contains('DISTRO_FEATURES', 'selinux', 'libselinux', '', d)}"

EXTRA_OEMAKE += "${@base_contains('DISTRO_FEATURES', 'selinux', 'WITH_SELINUX=\"yes\"', '', d)}"
