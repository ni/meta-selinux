SUMMARY = "SELinux binary policy manipulation library"
DESCRIPTION = "libsepol provides an API for the manipulation of SELinux binary policies. \
It is used by checkpolicy (the policy compiler) and similar tools, as well \
as by programs like load_policy that need to perform specific transformations \
on binary policies such as customizing policy boolean settings."
SECTION = "base"
PR = "r1"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

include selinux_20120216.inc
inherit lib_package

SRC_URI[md5sum] = "909dae553edb34ea2224002a0c529cb0"
SRC_URI[sha256sum] = "8f5ea42ae6cc00b21f0e5f31f354d19fcce3edfe9328971d266245718714b1e8"

SRC_URI += "file://libsepol-Change-ranlib-for-cross-compiling.patch"

BBCLASSEXTEND = "native"

