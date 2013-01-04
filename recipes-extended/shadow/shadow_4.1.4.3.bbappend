FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PR .= ".3"

inherit with-selinux with-audit
