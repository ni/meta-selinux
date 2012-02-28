SUMMARY = "Library to control and monitor control groups"
DESCRIPTION = "\
Control Groups provide a mechanism for aggregating/partitioning sets of \
tasks, and all their future children, into hierarchical groups with \
specialized  behaviour. \n\
This package contains tools and a library to allow users and applications \
to manipulate, control, administrate and monitor control groups and the \
associated controllers. \
"
SECTION = "libs"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

inherit autotools pkgconfig

DEPENDS = "${@base_contains('DISTRO_FEATURES', 'pam', 'libpam', '', d)}"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/libcg/libcgroup/v.038/libcgroup-${PV}.tar.bz2"
SRC_URI[md5sum] = "f0f7d4060bf36ccc19d75dbf4f1695db"
SRC_URI[sha256sum] = "5d36d1a48b95f62fe9fcdf74a5a4089512e5e43e6011aa1504fd6f2a0909867f"

EXTRA_OECONF = "${@base_contains('DISTRO_FEATURES', 'pam', '--enable-pam-module-dir=${base_libdir}/security --enable-pam=yes', '--enable-pam=no', d)}"

# http://www.mail-archive.com/openembedded-devel@lists.openembedded.org/msg21444.html
PARALLEL_MAKE = ""

PACKAGES =+ "cgroups-pam-plugin"
FILES_cgroups-pam-plugin = "${base_libdir}/security/pam_cgroup.so*"

# We really need the symlink so :(
ERROR_QA = "debug-deps dev-deps debug-files arch la2 pkgconfig la perms"

BBCLASSEXTEND = "native"
