inherit ${@bb.utils.contains('DISTRO_FEATURES', 'selinux', 'enable-selinux', '', d)}
PACKAGECONFIG[selinux] = ",,libselinux"
