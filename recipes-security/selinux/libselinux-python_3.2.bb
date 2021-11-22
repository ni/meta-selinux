SUMMARY = "SELinux library and simple utilities"
DESCRIPTION = "libselinux provides an API for SELinux applications to get and set \
process and file security contexts and to obtain security policy \
decisions.  Required for any applications that use the SELinux API."
SECTION = "base"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

require selinux_common.inc

inherit python3native python3targetconfig pkgconfig

FILESEXTRAPATHS:prepend := "${THISDIR}/libselinux:"
SRC_URI += "\
        file://0001-Makefile-fix-python-modules-install-path-for-multili.patch \
        file://0001-Do-not-use-PYCEXT-and-rely-on-the-installed-file-nam.patch \
        "

S = "${WORKDIR}/git/libselinux"

DEPENDS += "python3 swig-native libpcre libsepol"
RDEPENDS:${PN} += "libselinux python3-core python3-shell"

def get_policyconfigarch(d):
    import re
    target = d.getVar('TARGET_ARCH')
    p = re.compile('i.86')
    target = p.sub('i386',target)
    return "ARCH=%s" % (target)

EXTRA_OEMAKE += "${@get_policyconfigarch(d)}"
EXTRA_OEMAKE += "LDFLAGS='${LDFLAGS} -lpcre' LIBSEPOLA='${STAGING_LIBDIR}/libsepol.a'"
EXTRA_OEMAKE:append:libc-musl = " FTS_LDLIBS=-lfts"

FILES:${PN} = "${libdir}/python${PYTHON_BASEVERSION}/site-packages/*"
INSANE_SKIP:${PN} = "dev-so"

do_compile() {
    oe_runmake pywrap -j1 \
        PYLIBVER='python${PYTHON_BASEVERSION}${PYTHON_ABI}' \
        PYINC='-I${STAGING_INCDIR}/${PYLIBVER}' \
        PYLIBS='-L${STAGING_LIBDIR}/${PYLIBVER} -l${PYLIBVER}'
}

do_install() {
    oe_runmake install-pywrap \
        DESTDIR=${D} \
        PYLIBVER='python${PYTHON_BASEVERSION}${PYTHON_ABI}' \
        PYTHONLIBDIR='${libdir}/python${PYTHON_BASEVERSION}/site-packages'
}
