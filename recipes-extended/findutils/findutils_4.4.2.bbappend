PR .= ".3"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += "git://git.yoctogit.savannah.gnu.org/gnulib.git"
SRC_URI += "file://findutils-with-selinux.patch"
SRC_URI += "file://findutils-with-selinux-supplemental.patch"
SRCREV = "7dfa1250265017223e36c72713a7521421b4d27c"

DEPENDS += "${@base_contains('DISTRO_FEATURES', 'selinux', 'libselinux', '', d)}"

EXTRA_OECONF += "${@base_contains('DISTRO_FEATURES', 'selinux', '--with-selinux', '--without-selinux', d)}"

#Make sure we call import-gnulib to reflect on the new changes to its config.
do_configure_prepend () {
 ${S}/import-gnulib.sh
}
