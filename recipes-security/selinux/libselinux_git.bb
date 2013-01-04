PR = "r3"
PV = "2.1.9+git${SRCPV}"

include selinux_git.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://LICENSE;md5=84b4d2c6ef954a2d4081e775a270d0d0"

SRC_URI += "file://libselinux-fix-init-load-policy.patch"
