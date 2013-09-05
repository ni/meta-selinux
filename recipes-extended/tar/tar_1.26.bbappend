PR .= ".3"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://tar-1.24-xattrs.patch"

inherit enable-selinux


PACKAGECONFIG += "${@base_contains('DISTRO_FEATURES', 'acl', 'acl', '', d)}"

# configure has no acl enable/disable options!
#
PACKAGECONFIG[acl] = ",,acl,"

