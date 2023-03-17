PV = "2.20221101+git${SRCPV}"

SRC_URI = "git://github.com/SELinuxProject/refpolicy.git;protocol=https;branch=master;name=refpolicy;destsuffix=refpolicy"

SRCREV_refpolicy ?= "8e8f5e3ca3e5900cad126cb8b4fadaa8adb8caac"

UPSTREAM_CHECK_GITTAGREGEX = "RELEASE_(?P<pver>\d+_\d+)"

FILESEXTRAPATHS:prepend := "${THISDIR}/refpolicy:"

include refpolicy_common.inc
