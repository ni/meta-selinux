inherit enable-selinux

RDEPENDS:${PN}-runtime += "${@target_selinux(d, 'pam-plugin-selinux')}"
