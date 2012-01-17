SUMMARY = "SELinux policy compiler"
DESCRIPTION = "SELinux policy compiler"
SECTION = "base"
PR = "r1"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

include selinux.inc

SRC_URI[md5sum] = "c447f1d6cc6897f058d7e44e961fe3fd"
SRC_URI[sha256sum] = "9eaa15d1fbd23faebda9b1aef902d986edd3a9f9e75791e081b322875ab4f1aa"

SRC_URI += "file://test_makefile.patch"

DEPENDS += "libsepol flex-native flex"

EXTRA_OEMAKE += "INCLUDEDIR='${STAGING_INCDIR}' LIBDIR='${STAGING_LIBDIR}'"
