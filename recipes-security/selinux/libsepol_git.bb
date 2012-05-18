SUMMARY = "SELinux binary policy manipulation library"
DESCRIPTION = "libsepol provides an API for the manipulation of SELinux binary policies. \
It is used by checkpolicy (the policy compiler) and similar tools, as well \
as by programs like load_policy that need to perform specific transformations \
on binary policies such as customizing policy boolean settings."
SECTION = "base"
PR = "r1"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"
DEFAULT_PREFERENCE = "-1"

include selinux_git.inc
inherit lib_package

SRCREV = "339f8079d7b9dd1e0b0138e2d096dc7c60b2092e"
PV = "2.1.4+git${SRCPV}"

SRC_URI += "file://libsepol-Change-ranlib-for-cross-compiling.patch"

BBCLASSEXTEND = "native"

