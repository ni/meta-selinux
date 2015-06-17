FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://misc-xattr-add-xattr-module-stub.patch \
    file://mke2fs.c-create_inode.c-copy-xattrs.patch \
"
