SUMMARY = "Utilities to manipulate SELinux policy module package"
DESCRIPTION = "\
The utilities to create, expand, link and show the dependencies between \
the SELinux policy module packages."
SECTION = "base"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=393a5ca445f6965873eca0259a17f833"

require selinux_common.inc

DEPENDS += "libsepol"
RDEPENDS_${PN}-dev = ""

EXTRA_OEMAKE += "LIBSEPOLA=${STAGING_LIBDIR}/libsepol.a"

S = "${WORKDIR}/git/semodule-utils"

PACKAGES =+ "\
        ${PN}-semodule-expand \
        ${PN}-semodule-link \
        ${PN}-semodule-package \
"

FILES_${PN}-semodule-expand += "${bindir}/semodule_expand"
FILES_${PN}-semodule-link += "${bindir}/semodule_link"
FILES_${PN}-semodule-package += "\
        ${bindir}/semodule_package \
        ${bindir}/semodule_unpackage \
"

BBCLASSEXTEND = "native"
