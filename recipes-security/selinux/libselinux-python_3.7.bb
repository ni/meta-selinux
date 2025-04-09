SUMMARY = "SELinux library and simple utilities"
DESCRIPTION = "libselinux provides an API for SELinux applications to get and set \
process and file security contexts and to obtain security policy \
decisions.  Required for any applications that use the SELinux API."
SECTION = "base"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

require selinux_common.inc

inherit python3targetconfig pkgconfig

FILESEXTRAPATHS:prepend := "${THISDIR}/libselinux:"
SRC_URI += "\
        file://0001-Makefile-fix-python-modules-install-path-for-multili.patch \
        file://0002-Do-not-use-PYCEXT-and-rely-on-the-installed-file-nam.patch \
        file://0003-libselinux-restore-drop-the-obsolete-LSF-transitiona.patch \
        "

S = "${WORKDIR}/git/libselinux"

DEPENDS = "libsepol libpcre2 swig-native python3-setuptools-scm-native"
DEPENDS:append:libc-musl = " fts"

RDEPENDS:${PN} = "libselinux python3-core python3-shell"

def get_policyconfigarch(d):
    import re
    target = d.getVar('TARGET_ARCH')
    p = re.compile('i.86')
    target = p.sub('i386',target)
    return "ARCH=%s" % (target)

EXTRA_OEMAKE = "${@get_policyconfigarch(d)}"
EXTRA_OEMAKE:append:libc-musl = " FTS_LDLIBS=-lfts"

FILES:${PN} = "${PYTHON_SITEPACKAGES_DIR}/*"
INSANE_SKIP:${PN} = "dev-so"

do_compile() {
    oe_runmake pywrap -j1 \
        PYLIBVER='python${PYTHON_BASEVERSION}' \
        PYINC='-I${STAGING_INCDIR}/${PYLIBVER}' \
        PYLIBS='-L${STAGING_LIBDIR}/${PYLIBVER} -l${PYLIBVER}'
}

do_install() {
    oe_runmake install-pywrap \
        DESTDIR=${D} \
        PREFIX=${prefix}
        PYLIBVER='python${PYTHON_BASEVERSION}' \
        PYTHONLIBDIR='${PYTHON_SITEPACKAGES_DIR}'

    # Fix buildpaths issue
    sed -i -e 's,${WORKDIR},,g' \
        ${D}${PYTHON_SITEPACKAGES_DIR}/selinux-${PV}.dist-info/direct_url.json
}
