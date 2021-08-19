inherit ${@bb.utils.contains('DISTRO_FEATURES', 'selinux', 'enable-selinux', '', d)}
PACKAGECONFIG[selinux] = "--with-selinux,--without-selinux,libselinux"
