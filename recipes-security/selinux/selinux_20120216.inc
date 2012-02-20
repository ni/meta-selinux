SELINUX_RELEASE = "20120216"

SRC_URI = "http://userspace.selinuxproject.org/releases/${SELINUX_RELEASE}/${BPN}-${PV}.tar.gz"

PREFERRED_VERSION_checkpolicy = "2.1.8"
PREFERRED_VERSION_libselinux = "2.1.9"
PREFERRED_VERSION_libsemanage = "2.1.6"
PREFERRED_VERSION_libsepol = "2.1.4"
PREFERRED_VERSION_policycoreutils = "2.1.10"
PREFERRED_VERSION_sepolgen = "1.1.5"

include selinux_common.inc
