inherit selinux

PACKAGECONFIG:append = " ${@target_selinux(d)}"
PACKAGECONFIG[selinux] = "--with-selinux,--without-selinux,libselinux,"
