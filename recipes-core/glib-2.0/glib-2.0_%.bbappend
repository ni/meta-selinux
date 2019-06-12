inherit ${@bb.utils.contains('DISTRO_FEATURES', 'selinux', 'meson-enable-selinux', '', d)}
