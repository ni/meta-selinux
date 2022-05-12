SUMMARY = "Python modules and various SELinux utilities."
DESCRIPTION = "\
This package contains Python modules sepolgen, sepolicy; And the \
SELinux utilities audit2allow, chcat, semanage ..."
SECTION = "base"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=393a5ca445f6965873eca0259a17f833"

require selinux_common.inc

inherit python3native

SRC_URI += "file://fix-sepolicy-install-path.patch"

S = "${WORKDIR}/git/python"

EXTRA_OEMAKE += "LIBSEPOLA=${STAGING_LIBDIR}/libsepol.a"

DEPENDS += "python3 libsepol libselinux"
RDEPENDS:${BPN}-audit2allow += "\
        python3-core \
        libselinux-python \
        ${BPN}-sepolgen \
"
RDEPENDS:${BPN}-chcat += "\
        python3-core \
        python3-codecs \
        python3-shell \
        python3-stringold \
        python3-unixadmin \
        libselinux-python \
        ${BPN} \
"
RDEPENDS:${BPN} += "\
        python3-core \
        python3-codecs \
        python3-io \
        python3-ipy \
        python3-stringold \
        python3-syslog \
        python3-unixadmin \
        libselinux-python \
        libsemanage-python \
        setools \
"
RDEPENDS:${BPN}-semanage += "\
        python3-core \
        python3-ipy \
        python3-compression \
        python3-xml \
        python3-misc \
        libselinux-python \
        audit-python \
        ${BPN} \
"
RDEPENDS:${BPN}-sepolicy += "\
        python3-core \
        python3-codecs \
        python3-syslog \
        python3-multiprocessing \
        ${BPN} \
"
RDEPENDS:${BPN}-sepolgen-ifgen += "\
        python3-core \
        libselinux-python \
"

PACKAGES =+ "\
        ${PN}-audit2allow \
        ${PN}-sepolgen-ifgen \
        ${PN}-chcat \
        ${PN}-semanage \
        ${PN}-sepolgen \
        ${PN}-sepolicy \
"
FILES:${PN}-audit2allow = "\
        ${bindir}/audit2allow \
        ${bindir}/audit2why \
"
FILES:${PN}-chcat = "\
        ${bindir}/chcat \
"
FILES:${PN}-semanage = "\
        ${sbindir}/semanage \
        ${datadir}/bash-completion/completions/semanage \
"
# The ${bindir}/sepolgen is a symlink to ${bindir}/sepolicy
FILES:${PN}-sepolicy += "\
        ${bindir}/sepolgen \
        ${bindir}/sepolicy \
        ${datadir}/bash-completion/completions/sepolicy \
"
FILES:${PN}-sepolgen-ifgen += "\
        ${bindir}/sepolgen-ifgen \
        ${bindir}/sepolgen-ifgen-attr-helper \
"
FILES:${PN}-sepolgen += "\
        ${libdir}/python${PYTHON_BASEVERSION}/site-packages/sepolgen* \
        ${localstatedir}/lib/sepolgen/perm_map \
"

FILES:${PN} += "\
        ${libdir}/python${PYTHON_BASEVERSION}/site-packages/seobject.py* \
        ${libdir}/python${PYTHON_BASEVERSION}/site-packages/sepolicy*.egg-info \
        ${libdir}/python${PYTHON_BASEVERSION}/site-packages/sepolicy/* \
"

do_install() {
    oe_runmake DESTDIR="${D}" \
        PYLIBVER='python${PYTHON_BASEVERSION}' \
        PYTHONLIBDIR='${libdir}/python${PYTHON_BASEVERSION}/site-packages' \
        install
}
