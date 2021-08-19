inherit enable-selinux

PACKAGECONFIG[selinux] = ",,libselinux"

do_configure:append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'selinux', 'true', 'false', d)} ; then
        echo "#define HAVE_SELINUX 1" >> ${S}/config.h
        echo "HAVE_SELINUX=1" >> ${S}/config.make
    fi
}
