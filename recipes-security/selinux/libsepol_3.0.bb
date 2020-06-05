require selinux_20191204.inc
require ${BPN}.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "22ddb9994910cb9cfff5cb9663cb7ae7"
SRC_URI[sha256sum] = "5b7ae1881909f1048b06f7a0c364c5c8a86ec12e0ec76e740fe9595a6033eb79"

SRC_URI += "\
        file://0001-libsepol-fix-CIL_KEY_-build-errors-with-fno-common.patch \
        file://0001-libsepol-remove-leftovers-of-cil_mem_error_handler.patch \
        "
