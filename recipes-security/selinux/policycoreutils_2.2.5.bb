PR = "r0"

include selinux_20131030.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI[md5sum] = "a2963d7024c5c4ce89f2459d48f91ec8"
SRC_URI[sha256sum] = "bbf850a8c3c2f371f439d6525663eecdd3a737acd594d2f27f8d8f3a07830cc4"

SRC_URI += "\
	file://policycoreutils-revert-run_init-open_init_pty.patch \
	file://policycoreutils-fix-sepolicy-install-path.patch \
	file://policycoreutils-make-O_CLOEXEC-optional.patch \
	file://policycoreutils-loadpolicy-symlink.patch \
	"
