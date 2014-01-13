PR .= ".3"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

inherit with-selinux


PACKAGECONFIG += "${@base_contains('DISTRO_FEATURES', 'acl', 'acl', '', d)}"

# configure has no acl enable/disable options!
#
PACKAGECONFIG[acl] = ",,acl,"

