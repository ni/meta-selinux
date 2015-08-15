include selinux_20140506.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "e564e2b92d18db35707060da29cddab9"
SRC_URI[sha256sum] = "03e09e35e611c286e446bef92b6023ef2623815996f5a53394bb02e49a312e4b"

SRC_URI += "\
	file://libsemanage-Fix-execve-segfaults-on-Ubuntu.patch \
	file://libsemanage-fix-path-len-limit.patch \
	file://libsemanage-fix-path-nologin.patch \
	file://libsemanage-drop-Wno-unused-but-set-variable.patch \
	file://libsemanage-define-FD_CLOEXEC-as-necessary.patch;striplevel=2 \
	file://libsemanage-allow-to-disable-audit-support.patch \
	file://libsemanage-disable-expand-check-on-policy-load.patch \
	"
