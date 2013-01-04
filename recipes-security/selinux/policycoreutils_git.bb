PR = "r7"
PV = "2.1.10+git${SRCPV}"

include selinux_git.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI += "file://policycoreutils-fix-format-security.patch \
            file://policycoreutils-remove-empty-po-files.patch \
           "
