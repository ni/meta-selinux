PR = "r99"

include selinux_20131030.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI[md5sum] = "f330a90c566c8b564858d45399ce3dd1"
SRC_URI[sha256sum] = "3d2c8806742004693c2d4726abbc4f412340ee07bed407976dd8abeda09a4333"

SRC_URI += "\
	file://policycoreutils-fix-sepolicy-install-path.patch \
	file://policycoreutils-make-O_CLOEXEC-optional.patch \
	file://policycoreutils-loadpolicy-symlink.patch \
	file://policycoreutils-semanage-edit-user.patch \
	file://policycoreutils-process-ValueError-for-sepolicy-seobject.patch \
	file://policycoreutils-fix-TypeError-for-seobject.py.patch \
	"
