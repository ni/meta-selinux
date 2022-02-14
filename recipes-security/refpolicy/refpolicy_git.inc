PV = "2.20210203+git${SRCPV}"

SRC_URI = "git://github.com/SELinuxProject/refpolicy.git;protocol=https;branch=master;name=refpolicy;destsuffix=refpolicy"

SRCREV_refpolicy ?= "1167739da1882f9c89281095d2595da5ea2d9d6b"

UPSTREAM_CHECK_GITTAGREGEX = "RELEASE_(?P<pver>\d+_\d+)"

FILESEXTRAPATHS_prepend := "${THISDIR}/refpolicy:"

include refpolicy_common.inc
