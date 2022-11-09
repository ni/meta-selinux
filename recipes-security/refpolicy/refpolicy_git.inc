PV = "2.20221101+git${SRCPV}"

SRC_URI = "git://github.com/SELinuxProject/refpolicy.git;protocol=https;branch=master;name=refpolicy;destsuffix=refpolicy"

SRCREV_refpolicy ?= "03d486e306555da161b653c88e804ce23f3a0ea4"

UPSTREAM_CHECK_GITTAGREGEX = "RELEASE_(?P<pver>\d+_\d+)"

FILESEXTRAPATHS:prepend := "${THISDIR}/refpolicy:"

include refpolicy_common.inc
