SELINUX_RELEASE = "20130423"

SRC_URI = "http://userspace.selinuxproject.org/releases/${SELINUX_RELEASE}/${BPN}-${PV}.tar.gz"

PREFERRED_VERSION_checkpolicy = "2.1.12"
PREFERRED_VERSION_libselinux = "2.1.13"
PREFERRED_VERSION_libsemanage = "2.1.10"
PREFERRED_VERSION_libsepol = "2.1.9"
PREFERRED_VERSION_policycoreutils = "2.1.14"
PREFERRED_VERSION_sepolgen = "1.1.9"

include selinux_common.inc
