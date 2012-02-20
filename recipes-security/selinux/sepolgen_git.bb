SUMMARY = "Python modules for supporting various SELinux utilities."
DESCRIPTION = "Python modules for supporting various SELinux utilities."
SECTION = "base"
PR = "r1"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

include selinux_git.inc

SRCREV = "339f8079d7b9dd1e0b0138e2d096dc7c60b2092e"
PV = "1.1.5+git${SRCPV}" 
S = "${WORKDIR}/git/sepolgen"
 
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

