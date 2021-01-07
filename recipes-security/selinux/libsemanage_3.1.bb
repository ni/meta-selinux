require selinux_20200710.inc
require ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "d16eee8c1dc8cf43f59957d575d6bd29"
SRC_URI[sha256sum] = "22d6c75526e40d1781c30bcf29abf97171bdfe6780923f11c8e1c76a75a21ff8"

SRC_URI += "\
	file://libsemanage-Fix-execve-segfaults-on-Ubuntu.patch \
	file://libsemanage-define-FD_CLOEXEC-as-necessary.patch \
	file://libsemanage-allow-to-disable-audit-support.patch \
	file://libsemanage-disable-expand-check-on-policy-load.patch \
	"
