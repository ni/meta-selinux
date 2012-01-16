HOMEPAGE = "http://userspace.selinuxproject.org"

SRC_URI = "http://userspace.selinuxproject.org/releases/20110727/devel/${PN}-${PV}.tar.gz"

do_install() {
	oe_runmake install DESTDIR="${D}" PREFIX="${D}/${prefix}" INCLUDEDIR="${D}/${includedir}" LIBDIR="${D}/${libdir}" SHLIBDIR="${D}/${base_libdir}"
}
