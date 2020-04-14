SUMMARY = "SELinux library and simple utilities"
DESCRIPTION = "libselinux provides an API for SELinux applications to get and set \
process and file security contexts and to obtain security policy \
decisions.  Required for any applications that use the SELinux API."
SECTION = "base"
LICENSE = "PD"

FILESEXTRAPATHS_prepend := "${THISDIR}/libselinux:"

inherit python3native

DEPENDS += "python3 swig-native libpcre libsepol"
RDEPENDS_${PN} += "libselinux python3-core python3-shell"

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
