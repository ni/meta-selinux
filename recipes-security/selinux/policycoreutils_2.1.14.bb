PR = "r3"

include selinux_20130423.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI[md5sum] = "f34216414b650a0a25dec89a758234fb"
SRC_URI[sha256sum] = "b6881741f9f9988346a73bfeccb0299941dc117349753f0ef3f23ee86f06c1b5"

SRC_URI += "\
	file://policycoreutils-fix-strict-prototypes.patch \
	file://policycoreutils-revert-run_init-open_init_pty.patch \
	file://policycoreutils-fix-sepolicy-install-path.patch \
	"
