SUMMARY = "SELinux library and simple utilities"
DESCRIPTION = "libselinux provides an API for SELinux applications to get and set \
process and file security contexts and to obtain security policy \
decisions.  Required for any applications that use the SELinux API."
SECTION = "base"
PR = "r1"
LICENSE = "NSA-Public_Domain"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

include selinux.inc
inherit lib_package

SRC_URI[md5sum] = "df32d1650d2ae48cb88c1589c41a50c4"
SRC_URI[sha256sum] = "fbc4911c1103b00b0530ed21d1004ffa8c661342e1101ccf4c73a573f89f9caf"

DEPENDS += "libsepol python"

EXTRA_OEMAKE += "INCLUDEDIR='${STAGING_INCDIR}' LIBDIR='${STAGING_LIBDIR}' PYLIBVER='python${PYTHON_BASEVERSION}' PYINC='${STAGING_INCDIR}/$(PYLIBVER)' PYLIB='${STAGING_LIBDIR}/$(PYLIBVER)' PYTHONLIBDIR='$(PYLIB)'"

do_compile() {
	oe_runmake all pywrap
}
