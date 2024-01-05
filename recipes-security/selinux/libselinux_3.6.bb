SUMMARY = "SELinux library and simple utilities"
DESCRIPTION = "libselinux provides an API for SELinux applications to get and set \
process and file security contexts and to obtain security policy \
decisions.  Required for any applications that use the SELinux API."
SECTION = "base"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

require selinux_common.inc

inherit lib_package pkgconfig

FILESEXTRAPATHS:prepend := "${THISDIR}/libselinux:"
SRC_URI += "\
        file://0003-libselinux-restore-drop-the-obsolete-LSF-transitiona.patch \
        "

S = "${WORKDIR}/git/libselinux"

DEPENDS = "libsepol libpcre2"
DEPENDS:append:libc-musl = " fts"

def get_policyconfigarch(d):
    import re
    target = d.getVar('TARGET_ARCH')
    p = re.compile('i.86')
    target = p.sub('i386',target)
    return "ARCH=%s" % (target)

EXTRA_OEMAKE = "${@get_policyconfigarch(d)}"
EXTRA_OEMAKE:append:libc-musl = " FTS_LDLIBS=-lfts"

BBCLASSEXTEND = "native"
