include refpolicy-targeted_${PV}.bb

SUMMARY = "SELinux minimum policy"
DESCRIPTION = "\
This is a minimum reference policy with just core policy modules, and \
could be used as a base for customizing targeted policy. \
Pretty much everything runs as initrc_t or unconfined_t so all of the \
domains are unconfined. \
"

POLICY_NAME = "minimum"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:${THISDIR}/refpolicy-${PV}:${THISDIR}/refpolicy-targeted:"

CORE_POLICY_MODULES = "unconfined \
	selinuxutil storage sysnetwork \
	application libraries miscfiles logging userdomain \
	init mount modutils getty authlogin locallogin \
	"

# nscd caches libc-issued requests to the name service.
# Without nscd.pp, commands want to use these caches will be blocked.
EXTRA_POLICY_MODULES += "nscd"

# pam_mail module enables checking and display of mailbox status upon
# "login", so "login" process will access to /var/spool/mail.
EXTRA_POLICY_MODULES += "mta"

POLICY_MODULES_MIN = "${CORE_POLICY_MODULES} ${EXTRA_POLICY_MODULES}"
