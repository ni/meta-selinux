SUMMARY = "An alternate posix capabilities library"
DESCRIPTION = "The libcap-ng library is intended to make programming \
with POSIX capabilities much easier than the traditional libcap library. \
It includes utilities that can analyze all currently running \
applications to locate applications that may have too many privileges."
HOMEPAGE = "http://freecode.com/projects/libcap-ng"
SECTION = "base"
PR = "r1"
LICENSE = "GPLv2+ & LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f \
		    file://COPYING.LIB;md5=e3eda01d9815f8d24aae2dbd89b68b06"

SRC_URI = "http://people.redhat.com/sgrubb/libcap-ng/libcap-ng-${PV}.tar.gz \
	   file://python.patch"

inherit lib_package
inherit autotools

SRC_URI[md5sum] = "759ae1accd9954f3e08c2f94b4ecfcf9"
SRC_URI[sha256sum] = "293e2e308f08d171f64e8387cdf48b505b0e78d786e2660efd285295e64d6620"

DEPENDS += "python"

EXTRA_OEMAKE += "PYLIBVER='python${PYTHON_BASEVERSION}' PYINC='${STAGING_INCDIR}/$(PYLIBVER)'"

PACKAGES += "${PN}-python"

FILES_${PN}-dbg += "${libdir}/python${PYTHON_BASEVERSION}/*/.debug"
FILES_${PN}-python = "${libdir}/python${PYTHON_BASEVERSION}"

BBCLASSEXTEND = "native"
