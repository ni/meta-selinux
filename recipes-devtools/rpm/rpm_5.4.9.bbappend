PR .= ".1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://rpm-fix-build-bug.patch \
	   "

FILES_${PN} += "${libdir}/rpm/bin/spooktool \
                ${libdir}/rpm/bin/semodule \
               "

# Fix incorrect dependency in upstream version
PACKAGECONFIG[selinux] = "${WITH_SELINUX},${WITHOUT_SELINUX},libselinux,"
PACKAGECONFIG_append = " ${@base_contains('DISTRO_FEATURES', 'selinux', 'selinux', '', d)}"
