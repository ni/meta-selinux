inherit ${@bb.utils.contains('DISTRO_FEATURES', 'selinux', 'enable-selinux enable-audit', '', d)}

PACKAGECONFIG[audit] = "--with-linux-audit,--without-linux-audit,audit"
PACKAGECONFIG[selinux] = "--with-selinux,--without-selinux,libselinux"
