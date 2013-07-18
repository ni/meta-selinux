PR .= ".6"

inherit with-selinux with-audit

FILESEXTRAPATHS_prepend := "${@target_selinux(d, '${THISDIR}/files:')}"
