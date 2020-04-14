SUMMARY = "Python modules and various SELinux utilities."
DESCRIPTION = "\
This package contains Python modules sepolgen, sepolicy; And the \
SELinux utilities audit2allow, chcat, semanage ..."

SECTION = "base"
LICENSE = "GPLv2+"

SRC_URI += "file://fix-sepolicy-install-path.patch"

inherit python3native

DEPENDS += "python3 libsepol"
RDEPENDS_${BPN}-audit2allow += "\
        python3-core \
        libselinux-python \
        ${BPN}-sepolgen \
"
RDEPENDS_${BPN}-chcat += "\
        python3-core \
        python3-codecs \
        python3-shell \
        python3-stringold \
        python3-unixadmin \
        libselinux-python \
        ${BPN} \
"
RDEPENDS_${BPN} += "\
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
RDEPENDS_${BPN}-semanage += "\
        python3-core \
        python3-ipy \
        python3-compression \
        python3-xml \
        python3-misc \
        libselinux-python \
        ${BPN} \
"
RDEPENDS_${BPN}-sepolicy += "\
        python3-core \
        python3-codecs \
        python3-syslog \
        ${BPN} \
"
RDEPENDS_${BPN}-sepolgen-ifgen += "\
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
FILES_${PN}-audit2allow = "\
        ${bindir}/audit2allow \
        ${bindir}/audit2why \
"
FILES_${PN}-chcat = "\
        ${bindir}/chcat \
"
FILES_${PN}-semanage = "\
        ${sbindir}/semanage \
        ${datadir}/bash-completion/completions/semanage \
"
# The ${bindir}/sepolgen is a symlink to ${bindir}/sepolicy
FILES_${PN}-sepolicy += "\
        ${bindir}/sepolgen \
        ${bindir}/sepolicy \
        ${datadir}/bash-completion/completions/sepolicy \
"
FILES_${PN}-sepolgen-ifgen += "\
        ${bindir}/sepolgen-ifgen \
        ${bindir}/sepolgen-ifgen-attr-helper \
"
FILES_${PN}-sepolgen += "\
        ${libdir}/python${PYTHON_BASEVERSION}/site-packages/sepolgen* \
        ${localstatedir}/lib/sepolgen/perm_map \
"

FILES_${PN} += "\
        ${libdir}/python${PYTHON_BASEVERSION}/site-packages/seobject.py* \
        ${libdir}/python${PYTHON_BASEVERSION}/site-packages/sepolicy*.egg-info \
        ${libdir}/python${PYTHON_BASEVERSION}/site-packages/sepolicy/* \
"

EXTRA_OEMAKE += "LIBSEPOLA=${STAGING_LIBDIR}/libsepol.a"

do_install() {
        oe_runmake DESTDIR="${D}" \
                PYLIBVER='python${PYTHON_BASEVERSION}' \
                PYTHONLIBDIR='${libdir}/python${PYTHON_BASEVERSION}/site-packages' \
                install
}
