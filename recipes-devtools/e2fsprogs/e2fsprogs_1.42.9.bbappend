FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://misc-xattr-add-xattr-module-stub.patch \
"
