inherit enable-selinux enable-audit

do_install:append() {
	if ${@bb.utils.contains('PACKAGECONFIG', 'backlight', 'true', 'false', d)}; then
		install -d ${D}${localstatedir}/lib/systemd/backlight
	fi
}
