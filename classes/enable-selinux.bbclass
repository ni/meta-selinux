inherit selinux

PACKAGECONFIG:append = " ${@target_selinux(d, 'selinux')}"
