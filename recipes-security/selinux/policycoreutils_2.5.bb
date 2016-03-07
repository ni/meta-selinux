include selinux_20160223.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI[md5sum] = "9ad9331b2133262fb3f774359a7f4761"
SRC_URI[sha256sum] = "329382cfe9fa977678abf541dcd8fe3847cf0c83b24654c8f7322343907078a1"

SRC_URI += "\
	file://policycoreutils-fix-sepolicy-install-path.patch \
	file://policycoreutils-make-O_CLOEXEC-optional.patch \
	file://policycoreutils-loadpolicy-symlink.patch \
	file://policycoreutils-process-ValueError-for-sepolicy-seobject.patch \
	file://policycoreutils-fix-TypeError-for-seobject.py.patch \
	file://0001-mcstrans-fix-the-init-script.patch \
	file://enable-mcstrans.patch \
	file://policycoreutils-fts_flags-FTS_NOCHDIR.patch \
	"
