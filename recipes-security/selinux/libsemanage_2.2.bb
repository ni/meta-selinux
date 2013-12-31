PR = "r0"

include selinux_20131030.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "2a939538645de6023633bc2247a5e72e"
SRC_URI[sha256sum] = "11f60bfa0f1c6063cd9bd99ce0cb4acc9d6d9e9b8d7743d39e847bcd7803bd75"

SRC_URI += "\
	file://libsemanage-Fix-execve-segfaults-on-Ubuntu.patch \
	file://libsemanage-fix-path-len-limit.patch \
	file://libsemanage-fix-path-nologin.patch \
	file://libsemanage-drop-Wno-unused-but-set-variable.patch \
	file://libsemanage-define-FD_CLOEXEC-as-necessary.patch;striplevel=2 \
	"
