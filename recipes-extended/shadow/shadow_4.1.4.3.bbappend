DEPENDS += "${@base_contains('DISTRO_FEATURES', 'selinux', 'libselinux audit', '', d)}"

EXTRA_OECONF += "${@base_contains('DISTRO_FEATURES', 'selinux', '--with-selinux', '--without-selinux', d)}"
EXTRA_OECONF += "${@base_contains('DISTRO_FEATURES', 'selinux', '--with-audit', '--without-audit', d)}"

PR .= ".1"

