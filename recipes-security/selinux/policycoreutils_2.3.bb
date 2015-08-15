include selinux_20140506.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI[md5sum] = "9a5db20adfe2250f53833b277ac796ae"
SRC_URI[sha256sum] = "864cfaee58b5d2f15b140c354e59666e57143293c89f2b2e85bc0d0e4beefcd2"

SRC_URI += "\
	file://policycoreutils-fix-sepolicy-install-path.patch \
	file://policycoreutils-make-O_CLOEXEC-optional.patch \
	file://policycoreutils-loadpolicy-symlink.patch \
	file://policycoreutils-semanage-edit-user.patch \
	file://policycoreutils-process-ValueError-for-sepolicy-seobject.patch \
	file://policycoreutils-fix-TypeError-for-seobject.py.patch \
	file://0001-mcstrans-fix-the-init-script.patch \
	file://enable-mcstrans.patch \
	file://policycoreutils-fts_flags-FTS_NOCHDIR.patch \
	"
