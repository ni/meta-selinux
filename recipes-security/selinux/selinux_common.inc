HOMEPAGE = "https://github.com/SELinuxProject"

SRC_URI = "git://github.com/SELinuxProject/selinux.git;branch=main;protocol=https"
SRCREV = "97fa708d867ecb26e8d1c766760947f8e3b9e59a"

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
