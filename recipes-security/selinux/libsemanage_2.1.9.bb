PR = "r1"

include selinux_20120924.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "209e11da5b36c595a796751583f016f8"
SRC_URI[sha256sum] = "6f01d17f9751412f7b76e6e7daafeb2faf301b9bfeea83506160c81becf035cc"

SRC_URI += "\
	file://libsemanage-Fix-execve-segfaults-on-Ubuntu.patch \
	file://libsemanage-fix-path-len-limit.patch \
	file://libsemanage-fix-path-nologin.patch \
	file://libsemanage-drop-Wno-unused-but-set-variable.patch \
	"
