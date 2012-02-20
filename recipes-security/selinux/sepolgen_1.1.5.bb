SUMMARY = "Python modules for supporting various SELinux utilities."
DESCRIPTION = "Python modules for supporting various SELinux utilities."
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

