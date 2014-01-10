PR .= ".2"

inherit selinux

DEPENDS += "${LIBSELINUX}"

EXTRA_OEMAKE += "${@target_selinux(d, 'WITH_SELINUX=\"yes\"')}"
