PR .= ".1"

DEPENDS += "${@base_contains('DISTRO_FEATURES', 'selinux', 'libselinux', '', d)}"

do_configure_prepend () {
	export LINUX_HASSELINUX="${@base_contains('DISTRO_FEATURES', 'selinux', 'Y', 'N', d)}"
	export LSOF_CFGF="${CFLAGS}"
	export LSOF_CFGL="${LDFLAGS}"
	export LSOF_CC="${BUILD_CC}"
}

do_compile () {
	oe_runmake 'CC=${CC}' 'DEBUG='
}
