SRC_URI = "https://github.com/SELinuxProject/refpolicy/releases/download/RELEASE_2_20190201/refpolicy-${PV}.tar.bz2"
SRC_URI[md5sum] = "babb0d5ca2ae333631d25392b2b3ce8d"
SRC_URI[sha256sum] = "ed620dc91c4e09eee6271b373f7c61a364a82ea57bd2dc86ca1f7075304e2843"

UPSTREAM_CHECK_GITTAGREGEX = "RELEASE_(?P<pver>\d+_\d+)"

FILESEXTRAPATHS_prepend := "${THISDIR}/refpolicy-2.20190201:"

include refpolicy_common.inc
