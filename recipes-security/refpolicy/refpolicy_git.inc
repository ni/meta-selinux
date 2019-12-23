PV = "2.20190201+git${SRCPV}"

SRC_URI = "git://github.com/SELinuxProject/refpolicy.git;protocol=git;branch=master;name=refpolicy;destsuffix=refpolicy"

SRCREV_refpolicy ?= "df696a325404b84c2c931c85356510005e5e6916"

UPSTREAM_CHECK_GITTAGREGEX = "RELEASE_(?P<pver>\d+_\d+)"

FILESEXTRAPATHS_prepend := "${THISDIR}/refpolicy-git:"

include refpolicy_common.inc
