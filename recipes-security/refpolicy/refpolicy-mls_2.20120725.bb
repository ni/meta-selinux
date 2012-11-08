SUMMARY = "MLS (Multi Level Security) variant of the SELinux policy"
DESCRIPTION = "\
This is the reference policy for SE Linux built with MLS support. \
It allows giving data labels such as \"Top Secret\" and preventing \
such data from leaking to processes or files with lower classification. \
"

PR = "r1"

POLICY_NAME = "mls"
POLICY_TYPE = "mls"
POLICY_DISTRO = "redhat"
POLICY_UNK_PERMS = "allow"
POLICY_DIRECT_INITRC = "n"
POLICY_MONOLITHIC = "n"
POLICY_CUSTOM_BUILDOPT = ""
POLICY_QUIET = "y"

POLICY_MLS_SENS = "16"
POLICY_MLS_CATS = "1024"
POLICY_MCS_CATS = "1024"

include refpolicy_${PV}.inc
