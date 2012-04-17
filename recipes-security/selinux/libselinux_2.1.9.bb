SUMMARY = "SELinux library and simple utilities"
DESCRIPTION = "libselinux provides an API for SELinux applications to get and set \
process and file security contexts and to obtain security policy \
decisions.  Required for any applications that use the SELinux API."
SECTION = "base"
PR = "r1"
LICENSE = "Public Domain"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

include selinux_20120216.inc
inherit lib_package

SRC_URI[md5sum] = "8ea0548dd65e9479b357ba1447f89221"
SRC_URI[sha256sum] = "749d4b39c80aa9df8247b8b3187ab72442c0dbad6e70bf312e25052bd4e7063f"

SRC_URI += "file://libselinux-fix-init-load-policy.patch"

DEPENDS += "libsepol python python-native swig-native"

PACKAGES += "${PN}-python"
FILES_${PN}-python = "${libdir}/python${PYTHON_BASEVERSION}/site-packages/selinux/*"
FILES_${PN}-dbg += "${libdir}/python${PYTHON_BASEVERSION}/site-packages/selinux/.debug/*"

python __anonymous () {
	import re
	target = d.getVar('TARGET_ARCH', True)
	extra_oemake = d.getVar('EXTRA_OEMAKE', True)
	p = re.compile('i.86')
	target = p.sub('i386',target)
	d.setVar("EXTRA_OEMAKE", extra_oemake + " ARCH='" + target + "'")
}

do_compile_append() {
    oe_runmake pywrap -j1 \
            INCLUDEDIR='${STAGING_INCDIR}' \
            LIBDIR='${STAGING_LIBDIR}' \
            PYLIBVER='python${PYTHON_BASEVERSION}' \
            PYINC='-I${STAGING_INCDIR}/$(PYLIBVER)' \
            PYLIB='-L${STAGING_LIBDIR}/$(PYLIBVER) -l$(PYLIBVER)' \
            PYTHONLIBDIR='${PYLIB}'
}

do_install_append() {
    oe_runmake install-pywrap swigify \
            DESTDIR=${D} \
            PYLIBVER='python${PYTHON_BASEVERSION}' \
            PYLIBDIR='${D}/${libdir}/$(PYLIBVER)'
}

BBCLASSEXTEND = "native"
