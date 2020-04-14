SELINUX_RELEASE = "20191204"

SRC_URI = "https://github.com/SELinuxProject/selinux/releases/download/${SELINUX_RELEASE}/${BPN}-${PV}.tar.gz"

UPSTREAM_CHECK_URI = "https://github.com/SELinuxProject/selinux/releases"
UPSTREAM_CHECK_REGEX = "libselinux-(?P<pver>.+)\.tar\.gz"

require selinux_common.inc
