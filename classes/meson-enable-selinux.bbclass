inherit selinux

PACKAGECONFIG_append = " ${@target_selinux(d)}"
PACKAGECONFIG[selinux] = "-Dselinux=enabled,-Dselinux=disabled,libselinux,"
