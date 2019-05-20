inherit ${@bb.utils.contains('DISTRO_FEATURES', 'selinux', 'meson-selinux', '', d)}

