#FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_append := ":${@base_set_filespath(['${THISDIR}/${PN}'], d)}"

SRC_URI += "file://sepermit-add-DESTDIR-prefix.patch"

PR .= ".4"

inherit enable-selinux

RDEPENDS_${PN}-runtime += "${@target_selinux(d, 'pam-plugin-selinux')}"
