# There is still no audit DISTRO_FEATURE, so enable audit when selinux feature enabled.
inherit selinux

PACKAGECONFIG:append = " ${@target_selinux(d, 'audit')}"
