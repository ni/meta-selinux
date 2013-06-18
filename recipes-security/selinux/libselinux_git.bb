PR = "r0"
PV = "2.1.13+git${SRCPV}"

include selinux_git.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

SRC_URI += "file://libselinux-fix-init-load-policy.patch \
	file://libselinux-pcre-link-order.patch"
