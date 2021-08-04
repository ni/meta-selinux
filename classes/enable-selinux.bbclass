inherit selinux

PACKAGECONFIG:append = " ${@target_selinux(d)}"
PACKAGECONFIG[selinux] = "--enable-selinux,--disable-selinux,libselinux,"
