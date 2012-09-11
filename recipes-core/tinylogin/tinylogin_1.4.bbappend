PR .= ".2"

do_install () {
	install -d ${D}${base_bindir}
	install -m 4755 tinylogin ${D}${base_bindir}/tinylogin
	echo '#!'"${base_bindir}/tinylogin" > tinylogin_wrapper
	for i in `cat tinylogin.links`; do
		mkdir -p ${D}/`dirname $i`
		install -m 755 tinylogin_wrapper ${D}$i
	done
}

ALTERNATIVE_${PN} += "login"
ALTERNATIVE_LINK_NAME[login] = "${base_bindir}/login"
