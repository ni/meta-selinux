PR = "r4"

include selinux_20120216.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "b49d75602432d8cfad8a3e5a0a966f07"
SRC_URI[sha256sum] = "64e6849fe50fb463ec0ba24653a26e3452fa4aaa7d7e192213d5c5a7c525aebb"

SRC_URI += "file://Fix-segfault-for-standard-policy.patch \
	file://libsemanage-Fix-execve-segfaults-on-Ubuntu.patch \
	file://libsemanage-semanage.conf-for-cross-compile.patch \
	file://libsemanage-fix-path-len-limit.patch \
	file://libsemanage-fix-path-nologin.patch"
