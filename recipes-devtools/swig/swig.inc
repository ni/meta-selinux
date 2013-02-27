DESCRIPTION = "SWIG - Simplified Wrapper and Interface Generator"
HOMEPAGE = "http://swig.sourceforge.net/"
LICENSE = "BSD & GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e7807a6282784a7dde4c846626b08fc6 \
                    file://LICENSE-GPL;md5=d32239bcb673463ab874e80d47fae504 \
                    file://LICENSE-UNIVERSITIES;md5=e0eaeeef7b2662c0c2d0d3c0b2509f75"

SECTION = "devel"
INC_PR = "r2"

DEPENDS = "python"

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/${BPN}-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = " --without-guile "

BBCLASSEXTEND = "native"

do_configure() {
	oe_runconf
}

def swiglib_relpath(d):
    swiglib = d.getVar('datadir', True) + "/" + d.getVar('BPN', True) + "/" + d.getVar('PV', True)
    return os.path.relpath(swiglib, d.getVar('bindir', True))

do_install_append_class-native() {
	create_wrapper ${D}${bindir}/swig SWIG_LIB='`dirname $''realpath`'/${@swiglib_relpath(d)}
}
