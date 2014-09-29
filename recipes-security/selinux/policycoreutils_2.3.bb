include selinux_20140506.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI[md5sum] = "4f5c508e3c3867c8beb343e993d353dd"
SRC_URI[sha256sum] = "11e8815ac13debb87897d2781381b89ec5c6c746a3d44223a493bc7ace6cc71f"

SRC_URI += "\
	file://policycoreutils-fix-sepolicy-install-path.patch \
	file://policycoreutils-make-O_CLOEXEC-optional.patch \
	file://policycoreutils-loadpolicy-symlink.patch \
	file://policycoreutils-semanage-edit-user.patch \
	file://policycoreutils-process-ValueError-for-sepolicy-seobject.patch \
	file://policycoreutils-fix-TypeError-for-seobject.py.patch \
	"
