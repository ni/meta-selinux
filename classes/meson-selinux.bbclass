inherit selinux

PACKAGECONFIG_append = " ${@target_selinux(d)}"
PACKAGECONFIG[selinux] = "-Dselinux=true,-Dselinux=false,libselinux,"
