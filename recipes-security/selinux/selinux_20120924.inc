SELINUX_RELEASE = "20120924"

SRC_URI = "http://userspace.selinuxproject.org/releases/${SELINUX_RELEASE}/${BPN}-${PV}.tar.gz"

PREFERRED_VERSION_checkpolicy = "2.1.11"
PREFERRED_VERSION_libselinux = "2.1.12"
PREFERRED_VERSION_libsemanage = "2.1.9"
PREFERRED_VERSION_libsepol = "2.1.8"
PREFERRED_VERSION_policycoreutils = "2.1.13"
PREFERRED_VERSION_sepolgen = "1.1.8"

include selinux_common.inc
