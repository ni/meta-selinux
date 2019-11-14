SUMMARY = "Run cmd under an SELinux sandbox"
DESCRIPTION = "\
Run application within a tightly confined SELinux domain. The default \
sandbox domain only allows applications the ability to read and write \
stdin, stdout and any other file descriptors handed to it."

SECTION = "base"
LICENSE = "GPLv2+"

SRC_URI += "file://sandbox-de-bashify.patch \
"

DEPENDS += "libcap-ng libselinux"

RDEPENDS_${PN} += "\
        python3-core \
        python3-math \
        python3-shell \
        python3-unixadmin \
        libselinux-python \
        selinux-python \
"

FILES_${PN} += "\
        ${datadir}/sandbox/sandboxX.sh \
        ${datadir}/sandbox/start \
"
