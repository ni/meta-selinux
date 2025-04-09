SUMMARY = "Policy analysis tools for SELinux"
DESCRIPTION = "\
SETools is a collection of graphical tools, command-line tools, and \
libraries designed to facilitate SELinux policy analysis."
SECTION = "base"
LICENSE = "GPL-2.0-only & LGPL-2.1-only"

SRC_URI = "git://github.com/SELinuxProject/${BPN}.git;branch=4.5;protocol=https \
           file://setools4-fixes-for-cross-compiling.patch \
          "
SRCREV = "659ec47aba0126e3a198362ed1659bf600c067eb"

LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=69a7b68f0a4a570d7c0c43465333ecbc \
                    file://${S}/COPYING.GPL;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://${S}/COPYING.LGPL;md5=4fbd65380cdd255951079008b364516c"

S = "${WORKDIR}/git"

DEPENDS = "python3-cython-native libsepol libselinux"

RDEPENDS:${PN} = "python3-networkx python3-setuptools \
                  python3-logging libselinux-python"

RPROVIDES:${PN} = "${PN}-console"

inherit setuptools3

do_install:prepend() {
    sed -i -e 's:${RECIPE_SYSROOT}::g' ${S}/setools/policyrep.c
}

do_install:append() {
    # Need PyQt5 support, disable gui tools
    rm -f ${D}${bindir}/apol
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/setoolsgui
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/setools/__pycache__
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/setools/*/__pycache__
}
