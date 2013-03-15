SUMMARY = "An alternate posix capabilities library"
DESCRIPTION = "The libcap-ng library is intended to make programming \
with POSIX capabilities much easier than the traditional libcap library. \
It includes utilities that can analyze all currently running \
applications to locate applications that may have too many privileges."
HOMEPAGE = "http://freecode.com/projects/libcap-ng"
SECTION = "base"
PR = "r3"
LICENSE = "GPLv2+ & LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f \
		    file://COPYING.LIB;md5=e3eda01d9815f8d24aae2dbd89b68b06"

SRC_URI = "http://people.redhat.com/sgrubb/libcap-ng/libcap-ng-${PV}.tar.gz \
	   file://python.patch"

inherit lib_package autotools pythonnative

SRC_URI[md5sum] = "eb71f967cecb44b4342baac98ef8cb0f"
SRC_URI[sha256sum] = "89589a29a6b19068edd650dd4f626c10e84bfe63eacae7b1fd1f98f3ac8ea00d"

DEPENDS += "swig-native python"

EXTRA_OEMAKE += "PYLIBVER='python${PYTHON_BASEVERSION}' PYINC='${STAGING_INCDIR}/${PYLIBVER}'"

PACKAGES += "${PN}-python"

FILES_${PN}-dbg += "${libdir}/python${PYTHON_BASEVERSION}/*/.debug"
FILES_${PN}-python = "${libdir}/python${PYTHON_BASEVERSION}"

BBCLASSEXTEND = "native"

do_install_append() {
	# Moving libcap-ng to base_libdir
	if [ ! ${D}${libdir} -ef ${D}${base_libdir} ]; then
		mkdir -p ${D}/${base_libdir}/
		mv -f ${D}${libdir}/libcap-ng.so.* ${D}${base_libdir}/
		relpath=${@os.path.relpath("${base_libdir}", "${libdir}")}
		ln -sf ${relpath}/libcap-ng.so.0.0.0 ${D}${libdir}/libcap-ng.so
	fi
}
