#FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_append := ":${@base_set_filespath(['${THISDIR}/${PN}'], d)}"

SRC_URI += "file://sepermit-add-DESTDIR-prefix.patch"

DEPENDS += "${@base_contains('DISTRO_FEATURES', 'selinux', 'libselinux', '', d)}"

EXTRA_OECONF += "${@base_contains('DISTRO_FEATURES', 'selinux', '', '--disable-selinux', d)}"

PR .= ".2"

