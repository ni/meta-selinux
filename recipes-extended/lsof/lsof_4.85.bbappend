PR .= ".1"

DEPENDS += "${@base_contains('DISTRO_FEATURES', 'selinux', 'libselinux', '', d)}"

do_configure_prepend() {
        export LINUX_HASSELINUX="${@base_contains('DISTRO_FEATURES', 'selinux', 'Y', 'N', d)}"
}
