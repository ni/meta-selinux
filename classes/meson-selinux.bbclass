inherit selinux

PACKAGECONFIG:append = " ${@target_selinux(d)}"
PACKAGECONFIG[selinux] = "-Dselinux=true,-Dselinux=false,libselinux,"
