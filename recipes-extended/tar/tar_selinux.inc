inherit with-selinux

PACKAGECONFIG:append = "${@bb.utils.contains('DISTRO_FEATURES', 'acl', ' acl', '', d)}"
