SRC_URI = "https://github.com/SELinuxProject/refpolicy/releases/download/RELEASE_2_20190201/refpolicy-${PV}.tar.bz2"
SRC_URI[md5sum] = "76a7a455289c9216ee0fbb8de71c9799"
SRC_URI[sha256sum] = "5e4daee61d89dfdc8c7bf369f81c99845931e337916dc6401e301c5de57ea336"

FILESEXTRAPATHS_prepend := "${THISDIR}/refpolicy-2.20190201:"

include refpolicy_common.inc
