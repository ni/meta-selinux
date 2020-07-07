SUMMARY = "SELinux targeted policy"
DESCRIPTION = "\
This is the targeted variant of the SELinux reference policy.  Most service \
domains are locked down. Users and admins will login in with unconfined_t \
domain, so they have the same access to the system as if SELinux was not \
enabled. \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/refpolicy-${PV}:"

POLICY_NAME = "targeted"
POLICY_TYPE = "mcs"
POLICY_MLS_SENS = "0"

include refpolicy_${PV}.inc

SRC_URI += " \
        file://0001-refpolicy-targeted-make-unconfined_u-the-default-sel.patch \
        "
