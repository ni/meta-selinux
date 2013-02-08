PR = "r4"
PV = "2.1.6+git${SRCPV}"

include selinux_git.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI += "file://Fix-segfault-for-standard-policy.patch \
	file://libsemanage-Fix-execve-segfaults-on-Ubuntu.patch \
	file://libsemanage-semanage.conf-for-cross-compile.patch \
	file://libsemanage-fix-path-len-limit.patch \
	file://libsemanage-fix-path-nologin.patch"
