SUMMARY = "Python modules for supporting various SELinux utilities."
DESCRIPTION = "\
This package contains a Python module that forms the core of the \
modern audit2allow (which is a part of the package policycoreutils). \
The sepolgen library is structured to give flexibility to the \
application using it. The library contains: Reference Policy \
Representation, which are Objects for representing policies and the \
reference policy interfaces. Secondly, it has objects and algorithms \
for representing access and sets of access in an abstract way and \
searching that access. It also has a parser for reference policy \
"headers". It contains infrastructure for parsing SELinux related \
messages as produced by the audit system. It has facilities for \
generating policy based on required access."
 
SECTION = "base"
PR = "r1"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

include selinux_20120216.inc

SRC_URI[md5sum] = "4ecadef3880019d8cdc08896687608b1"
SRC_URI[sha256sum] = "16c2b10510be7dbb2dc0967aedb2d69c654ca52ed03d04881c17d2f8b863b3bb"

FILES_${PN} = "${libdir}/python${PYTHON_BASEVERSION}/site-packages/*"

DEPENDS += "python"

FILES_${PN} += "${libdir}/python${PYTHON_BASEVERSION}/site-packages \
		/var/lib/sepolgen"

do_install() {
	oe_runmake DESTDIR=${D} \
			PYTHONLIBDIR='${libdir}/python${PYTHON_BASEVERSION}/site-packages' \
			install
}

BBCLASSEXTEND = "native"

