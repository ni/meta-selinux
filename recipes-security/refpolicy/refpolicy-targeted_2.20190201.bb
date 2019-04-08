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

SYSTEMD_REFPOLICY_PATCHES = " \
	file://0001-refpolicy-minimum-audit-logging-getty-audit-related-.patch \
	file://0002-refpolicy-minimum-locallogin-add-allow-rules-for-typ.patch \
	file://0003-refpolicy-minimum-systemd-unconfined-lib-add-systemd.patch \
	file://0004-refpolicy-minimum-systemd-mount-logging-authlogin-ad.patch \
	file://0005-refpolicy-minimum-init-fix-reboot-with-systemd-as-in.patch \
	file://0006-refpolicy-minimum-systemd-mount-enable-required-refp.patch \
	file://0007-refpolicy-minimum-systemd-fix-for-login-journal-serv.patch \
	file://0008-refpolicy-minimum-systemd-fix-for-systemd-tmp-files-.patch \
	file://0009-refpolicy-minimum-systemd-fix-for-syslog.patch \
	"

SYSVINIT_REFPOLICY_PATCHES = " \
	file://0001-fix-update-alternatives-for-sysvinit.patch \
	"

SRC_URI += " \
	${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '${SYSTEMD_REFPOLICY_PATCHES}', '${SYSVINIT_REFPOLICY_PATCHES}', d)} \
	"
