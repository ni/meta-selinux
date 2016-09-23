inherit with-selinux

do_configure_append() {
	if ${@bb.utils.contains('DISTRO_FEATURES', 'selinux', 'true', 'false', d)}; then
		sed -i 's/\(HAVE_SELINUX:=\).*/\1y/' ${B}/Config
	else
		sed -i 's/\(HAVE_SELINUX:=\).*/\1n/' ${B}/Config
	fi
}
