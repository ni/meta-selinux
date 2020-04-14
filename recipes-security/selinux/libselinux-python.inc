SUMMARY = "SELinux library and simple utilities"
DESCRIPTION = "libselinux provides an API for SELinux applications to get and set \
process and file security contexts and to obtain security policy \
decisions.  Required for any applications that use the SELinux API."
SECTION = "base"
LICENSE = "PD"

FILESEXTRAPATHS_prepend := "${THISDIR}/libselinux:"

inherit python-dir

DEPENDS += "python-native swig-native libpcre libsepol"
RDEPENDS_${PN} += "libselinux python-core python-shell"

def get_policyconfigarch(d):
    import re
    target = d.getVar('TARGET_ARCH')
    p = re.compile('i.86')
    target = p.sub('i386',target)
    return "ARCH=%s" % (target)
EXTRA_OEMAKE += "${@get_policyconfigarch(d)}"

EXTRA_OEMAKE += "LDFLAGS='${LDFLAGS} -lpcre' LIBSEPOLA='${STAGING_LIBDIR}/libsepol.a'"
EXTRA_OEMAKE_append_libc-musl = " FTS_LDLIBS=-lfts"

FILES_${PN} = "${libdir}/python${PYTHON_BASEVERSION}/site-packages/*"
INSANE_SKIP_${PN} = "dev-so"

do_compile() {
    oe_runmake pywrap -j1 \
            INCLUDEDIR='${STAGING_INCDIR}' \
            LIBDIR='${STAGING_LIBDIR}' \
            PYLIBVER='python${PYTHON_BASEVERSION}' \
            PYINC='-I${STAGING_INCDIR}/$(PYLIBVER)' \
            PYLIB='-L${STAGING_LIBDIR}/$(PYLIBVER) -l$(PYLIBVER)' \
            PYTHONLIBDIR='${PYLIB}'
}

do_install() {
    oe_runmake install-pywrap \
            PYCEXT='.so' \
            PYTHONLIBDIR='${D}${libdir}/python${PYTHON_BASEVERSION}/site-packages' \
            PYLIBVER='python${PYTHON_BASEVERSION}' \
            PYLIBDIR='${D}/${libdir}/$(PYLIBVER)'
}
