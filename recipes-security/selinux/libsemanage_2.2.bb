PR = "r99"

include selinux_20131030.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "2bb8f4b728a5667519764297b7725c19"
SRC_URI[sha256sum] = "9b421ce1df10594cb467eef37faeb403d5c6b341a4b7e4b407ac4cb77df95cba"

SRC_URI += "\
	file://libsemanage-Fix-execve-segfaults-on-Ubuntu.patch \
	file://libsemanage-fix-path-len-limit.patch \
	file://libsemanage-fix-path-nologin.patch \
	file://libsemanage-drop-Wno-unused-but-set-variable.patch \
	file://libsemanage-define-FD_CLOEXEC-as-necessary.patch;striplevel=2 \
	file://libsemanage-allow-to-disable-audit-support.patch \
	file://libsemanage-disable-expand-check-on-policy-load.patch \
	"
