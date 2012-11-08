SUMMARY = "Standard variants of the SELinux policy"
DESCRIPTION = "\
This is the reference policy for SELinux built with type enforcement \
only."

PR = "r1"

POLICY_NAME = "standard"
POLICY_TYPE = "standard"
POLICY_DISTRO = "redhat"
POLICY_UNK_PERMS = "allow"
POLICY_DIRECT_INITRC = "n"
POLICY_MONOLITHIC = "n"
POLICY_CUSTOM_BUILDOPT = ""
POLICY_QUIET = "y"

include refpolicy_${PV}.inc
