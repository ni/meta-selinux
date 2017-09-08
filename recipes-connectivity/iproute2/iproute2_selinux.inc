inherit with-selinux

do_configure_append() {
	sed -i 's/\(HAVE_SELINUX:=\).*/\1y/' ${B}/Config
}
