inherit ${@bb.utils.contains('DISTRO_FEATURES', 'selinux', 'enable-audit', '', d)}
