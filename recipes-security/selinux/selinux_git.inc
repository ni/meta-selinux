HOMEPAGE = "http://userspace.selinuxproject.org"

SRC_URI = "git://oss.tresys.com/git/selinux.git;protocol=http"
SRC_URI[md5sum] = "4ec64a0d24aaa77c80b86e74d271e464"
SRC_URI[sha256sum] = "9c8a8643c9a4dd0eb76fcda1420d636b750b84b27656c6f8bc6886a829d7e520"

S = "${WORKDIR}/git/${BPN}"

# EXTRA_OEMAKE is typically: -e MAKEFLAGS=
# "MAKEFLAGS= " causes problems as ENV variables will not pass to subdirs, so
# we redefine EXTRA_OEMAKE here
EXTRA_OEMAKE = "-e"

do_compile() {
    oe_runmake all \
            INCLUDEDIR='${STAGING_INCDIR}' \
            LIBDIR='${STAGING_LIBDIR}'
}

do_install() {
    oe_runmake install \
            DESTDIR="${D}" \
            PREFIX="${D}/${prefix}" \
            INCLUDEDIR="${D}/${includedir}" \
            LIBDIR="${D}/${libdir}" \
            SHLIBDIR="${D}/${base_libdir}"
}
