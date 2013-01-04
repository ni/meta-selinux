PR = "r7"

include selinux_20120216.inc
include ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI[md5sum] = "fefdede2815cdd2ba8b68599fef1f257"
SRC_URI[sha256sum] = "8bbbc36b7d375edff891503932da93e37553f0dd7bdceded7ce9a45c80bec3d1"

SRC_URI += "file://policycoreutils-fix-format-security.patch \
            file://policycoreutils-remove-empty-po-files.patch \
           "
