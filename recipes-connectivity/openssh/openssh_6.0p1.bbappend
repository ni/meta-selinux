PR .= ".1"

DEPENDS += "${@base_contains('DISTRO_FEATURES', 'selinux', 'libselinux', '', d)}"

EXTRA_OECONF += "${@base_contains('DISTRO_FEATURES', 'selinux', '--with-selinux', '--without-selinux', d)}"
