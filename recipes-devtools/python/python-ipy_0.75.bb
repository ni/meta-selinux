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

PR = "r1"

SRC_URI = "http://pypi.python.org/packages/source/I/IPy/IPy-${PV}.tar.gz"

SRC_URI[md5sum] = "d56716a3d8c77fe8539b6e90c88010bd"
SRC_URI[sha256sum] = "0fa14af4792cc0b6f61cb5a1cd8fbdf7ddbaa6864ef82681021b750e9e6b2b61"

S = "${WORKDIR}/IPy-${PV}"

inherit distutils

# need to export these variables for python-config to work
export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"

do_install_append() {
	install -d ${D}/${datadir}/doc/${PN}-${PV}
	install AUTHORS COPYING ChangeLog PKG-INFO README ${D}/${datadir}/doc/${PN}-${PV}
}
