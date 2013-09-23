PR = "r3"

include selinux_20120924.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI[md5sum] = "97c0b828599fe608f37894989820d71d"
SRC_URI[sha256sum] = "34040f06f3111d9ee957576e4095841d35b9ca9141ee8d80aab036cbefb28584"

SRC_URI += "\
	file://policycoreutils-revert-restorecon-update-type.patch \
	file://policycoreutils-revert-run_init-open_init_pty.patch \
	file://scripts_makefile.patch \
	"
