inherit ${@bb.utils.contains('DISTRO_FEATURES', 'selinux', 'enable-selinux enable-audit', '', d)}
PACKAGECONFIG[selinux] = "--with-selinux,--without-selinux,libselinux"
