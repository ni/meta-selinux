SUMMARY = "Python module for handling IPv4 and IPv6 Addresses and Networks"
DESCRIPTION = "IPy is a Python module for handling IPv4 and IPv6 Addresses and Networks \ 
in a fashion similar to perl's Net::IP and friends. The IP class allows \
a comfortable parsing and handling for most notations in use for IPv4 \
and IPv6 Addresses and Networks."
SECTION = "devel/python"
HOMEPAGE = "https://github.com/haypo/python-ipy"
DEPENDS = "python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=ebc0028ff5cdaf7796604875027dcd55"

SRC_URI = "http://pypi.python.org/packages/source/I/IPy/IPy-${PV}.tar.gz"

SRC_URI[md5sum] = "7a305c0b60950a9a90c89e9a6f9e06f4"
SRC_URI[sha256sum] = "4bc17a9b5e72e893a034e77193b82c2bc321ddf8d8c345281f2bb81bb007b939"

S = "${WORKDIR}/IPy-${PV}"

inherit distutils

# need to export these variables for python-config to work
export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"

do_install_append() {
	install -d ${D}/${datadir}/doc/${BPN}-${PV}
	install AUTHORS COPYING ChangeLog PKG-INFO README ${D}/${datadir}/doc/${BPN}-${PV}
}
