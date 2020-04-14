SUMMARY = "Policy analysis tools for SELinux"
DESCRIPTION = "\
SETools is a collection of graphical tools, command-line tools, and \
libraries designed to facilitate SELinux policy analysis. \
\n\
This meta-package depends upon the main packages necessary to run \
SETools."
SECTION = "base"
LICENSE = "GPLv2 & LGPLv2.1"

S = "${WORKDIR}/git"
SRC_URI = "git://github.com/SELinuxProject/${BPN}.git;branch=4.3 \
           file://setools4-fixes-for-cross-compiling.patch \
"

SRCREV = "a57ad3cdb669a39f785c4e85d63416a469c8d445"

LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=83a5eb6974c11f30785e90d0eeccf40c \
                    file://${S}/COPYING.GPL;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://${S}/COPYING.LGPL;md5=4fbd65380cdd255951079008b364516c"

DEPENDS += "bison-native flex-native swig-native python3 python3-cython-native libsepol libselinux"

RDEPENDS_${PN} += "python3-networkx python3-decorator python3-setuptools \
                   python3-logging python3-json libselinux-python"

RPROVIDES_${PN} += "${PN}-console"

inherit setuptools3

do_install_append() {
	# Need PyQt5 support, disable gui tools
	rm -f ${D}${bindir}/apol
	rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/setoolsgui
	rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/setools/__pycache__
	rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/setools/*/__pycache__
}
