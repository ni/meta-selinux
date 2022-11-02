require ${@bb.utils.contains('DISTRO_FEATURES', 'selinux', 'base-files_selinux.inc', '', d)}
