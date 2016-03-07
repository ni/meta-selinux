include selinux_20160223.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "eb030c863de1a6b3e2614a5c043c1641"
SRC_URI[sha256sum] = "46e2f36254369b6e91d1eea0460c262b139361b055a3a67d3ceea2d8ef72e006"

SRC_URI += "\
	file://libsemanage-Fix-execve-segfaults-on-Ubuntu.patch \
	file://libsemanage-fix-path-len-limit.patch \
	file://libsemanage-fix-path-nologin.patch \
	file://libsemanage-drop-Wno-unused-but-set-variable.patch \
	file://libsemanage-define-FD_CLOEXEC-as-necessary.patch;striplevel=2 \
	file://libsemanage-allow-to-disable-audit-support.patch \
	file://libsemanage-disable-expand-check-on-policy-load.patch \
	file://0001-src-Makefile-fix-includedir-in-libselinux.pc.patch \
	"
FILES_${PN} += "/usr/libexec"
