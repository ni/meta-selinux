HOMEPAGE = "https://github.com/SELinuxProject"

SRC_URI = "git://github.com/SELinuxProject/selinux.git;branch=main;protocol=https"
SRCREV = "2eb286bc0841791043567437ba5413f3014fb94e"

UPSTREAM_CHECK_GITTAGREGEX = "(?P<pver>\d+(\.\d+)+)"

do_compile() {
    oe_runmake all
}

do_install() {
    oe_runmake install \
        DESTDIR="${D}" \
        PREFIX="${prefix}" \
        INCLUDEDIR="${includedir}" \
        LIBDIR="${libdir}" \
        SHLIBDIR="${base_libdir}"
}

CVE_PRODUCT ?= "kernel:selinux"

CVE_STATUS[CVE-2020-10751] = "fixed-version: Fix is present in the current kernel version."
