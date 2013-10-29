SUMMARY = "MCS (Multi Category Security) variant of the SELinux policy"
DESCRIPTION = "\
This is the reference policy for SE Linux built with MCS support. \
An MCS policy is the same as an MLS policy but with only one sensitivity \
level. This is useful on systems where a hierarchical policy (MLS) isn't \
needed (pretty much all systems) but the non-hierarchical categories are. \
"

PR = "r0"

POLICY_NAME = "mcs"
POLICY_TYPE = "mcs"
POLICY_DISTRO = "redhat"
POLICY_UBAC = "n"
POLICY_UNK_PERMS = "allow"
POLICY_DIRECT_INITRC = "n"
POLICY_MONOLITHIC = "n"
POLICY_CUSTOM_BUILDOPT = ""
POLICY_QUIET = "y"

POLICY_MCS_CATS = "1024"

include refpolicy_${PV}.inc
