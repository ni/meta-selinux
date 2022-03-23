SUMMARY = "Policy analysis tools for SELinux"
DESCRIPTION = "\
SETools is a collection of graphical tools, command-line tools, and \
libraries designed to facilitate SELinux policy analysis. \
\n\
This meta-package depends upon the main packages necessary to run \
SETools."
SECTION = "base"
LICENSE = "GPL-2.0-only & LGPL-2.1-only"

S = "${WORKDIR}/git"
SRC_URI = "git://github.com/SELinuxProject/${BPN}.git;branch=4.4;protocol=https \
           file://setools4-fixes-for-cross-compiling.patch \
"

SRCREV = "4758cdf803d93274f49cb6445cb2bab527d6549f"

LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=83a5eb6974c11f30785e90d0eeccf40c \
                    file://${S}/COPYING.GPL;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://${S}/COPYING.LGPL;md5=4fbd65380cdd255951079008b364516c"

DEPENDS += "bison-native flex-native swig-native python3 python3-cython-native libsepol libselinux"

RDEPENDS:${PN} += "python3-networkx python3-decorator python3-setuptools \
                   python3-logging python3-json libselinux-python"

RPROVIDES:${PN} += "${PN}-console"

inherit setuptools3

do_install:append() {
	# Need PyQt5 support, disable gui tools
	rm -f ${D}${bindir}/apol
	rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/setoolsgui
	rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/setools/__pycache__
	rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/setools/*/__pycache__
}
