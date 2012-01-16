SUMMARY = "SELinux binary policy manipulation library"
DESCRIPTION = "libsepol provides an API for the manipulation of SELinux binary policies. \
It is used by checkpolicy (the policy compiler) and similar tools, as well \
as by programs like load_policy that need to perform specific transformations \
on binary policies such as customizing policy boolean settings."
SECTION = "base"
PR = "r1"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

include selinux.inc
inherit lib_package

SRC_URI[md5sum] = "66677a14e3618753c69a05bc65efae75"
SRC_URI[sha256sum] = "67fda7fc0944410fb021e6dc565d88714a7ccd3be276149ce518ab6086f129fe"


