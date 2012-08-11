PR .= ".4"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "git://git.savannah.gnu.org/gnulib.git;protocol=git;rev=0e0635af0b23826911dc456bd0da40dcb19247de"
SRC_URI += "file://findutils-with-selinux.patch"
SRC_URI += "file://findutils-with-selinux-gnulib.patch"

DEPENDS += "${@base_contains('DISTRO_FEATURES', 'selinux', 'libselinux', '', d)}"

EXTRA_OECONF += "${@base_contains('DISTRO_FEATURES', 'selinux', '--with-selinux', '--without-selinux', d)}"

do_configure_prepend() {
       ./import-gnulib.sh -d ${WORKDIR}/git
}

