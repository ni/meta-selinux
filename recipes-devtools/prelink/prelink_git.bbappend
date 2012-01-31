DEPENDS += "${@base_contains('DISTRO_FEATURES', 'selinux', 'libselinux', '', d)}"

EXTRA_OECONF += "${@base_contains('DISTRO_FEATURES', 'selinux', '--enable-selinux', '--disable-selinux', d)}"

PR .= ".1"

