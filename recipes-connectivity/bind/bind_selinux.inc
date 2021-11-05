do_install:append() {
	sed -i '/^\s*\/usr\/sbin\/rndc-confgen/a\
	    [ -x /sbin/restorecon ] && /sbin/restorecon -F /etc/bind/rndc.key' ${D}${sysconfdir}/init.d/bind
}
