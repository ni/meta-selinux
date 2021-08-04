inherit selinux

PACKAGECONFIG:append = " ${@target_selinux(d)}"
PACKAGECONFIG[selinux] = "-Dselinux=enabled,-Dselinux=disabled,libselinux,"
