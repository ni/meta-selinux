PR = "r0"

include selinux_20130423.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "44fc8a3387486378a21d8df7454b9d42"
SRC_URI[sha256sum] = "de2e8077245581e94576276f54e80a53c23c28d6961d2dfbe2f004eaba452e91"

SRC_URI += "\
	file://libsemanage-Fix-execve-segfaults-on-Ubuntu.patch \
	file://libsemanage-fix-path-len-limit.patch \
	file://libsemanage-fix-path-nologin.patch \
	file://libsemanage-drop-Wno-unused-but-set-variable.patch \
	"
