require ${@bb.utils.contains('DISTRO_FEATURES', 'selinux', 'sysvinit_selinux.inc', '', d)}
