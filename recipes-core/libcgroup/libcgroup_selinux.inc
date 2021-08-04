EXTRA_OECONF:append:class-native = " --enable-pam=no"

do_install:append() {
	test ! -f ${D}${base_libdir}/security/pam_cgroup.so.0.0.0 || {
		mv -f ${D}${base_libdir}/security/pam_cgroup.so.0.0.0 ${D}${base_libdir}/security/pam_cgroup.so
		rm -f ${D}${base_libdir}/security/pam_cgroup.so.*
	}
}

BBCLASSEXTEND = "native"
