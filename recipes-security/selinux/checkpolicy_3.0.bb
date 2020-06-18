require selinux_20191204.inc
require ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI[md5sum] = "b7c5547b95ce855bcdc10cb8adba8223"
SRC_URI[sha256sum] = "c88c719a141dd5c1202d49c378c7f063349d630522d5e04dc6e0c53da81aa4f8"

SRC_URI += "\
       file://0001-checkpolicy-remove-unused-te_assertions.patch \
"
