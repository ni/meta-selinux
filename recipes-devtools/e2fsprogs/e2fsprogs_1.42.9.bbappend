FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://misc-xattr-add-xattr-module-stub.patch \
    file://mke2fs.c-create_inode.c-copy-xattrs.patch \
    file://lib-ext2fs-ext2_ext_attr.h-add-xattr-index.patch \
"