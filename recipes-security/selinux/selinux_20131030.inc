SELINUX_RELEASE = "20131030"

SRC_URI = "http://userspace.selinuxproject.org/releases/${SELINUX_RELEASE}/${BPN}-${PV}.tar.gz"

PREFERRED_VERSION_checkpolicy = "2.2"
PREFERRED_VERSION_libselinux = "2.2"
PREFERRED_VERSION_libsemanage = "2.2"
PREFERRED_VERSION_libsepol = "2.2"
PREFERRED_VERSION_policycoreutils = "2.2.5"
PREFERRED_VERSION_sepolgen = "1.2.1"

include selinux_common.inc
