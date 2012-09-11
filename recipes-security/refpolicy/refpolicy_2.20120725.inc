SRC_URI = "http://oss.tresys.com/files/refpolicy/refpolicy-${PV}.tar.bz2;"
SRC_URI[md5sum] = "8aaa8a23cc1b7b7045f6f134e879ddb7"
SRC_URI[sha256sum] = "7cd46ed908a4001368e6509d93e306ec6c9af2bfa6b70db88c9eaaefe257c635"

FILESEXTRAPATHS_prepend := "${THISDIR}/refpolicy-${PV}:"

# Fix file contexts for Poky
SRC_URI += "file://poky-fc-subs_dist.patch \
            file://poky-fc-update-alternatives_sysvinit.patch \
            file://poky-fc-update-alternatives_tinylogin.patch \
            file://poky-fc-update-alternatives_sysklogd.patch \
            file://poky-fc-update-alternatives_hostname.patch \
            file://poky-fc-fix-prefix-path_rpc.patch \
            file://poky-fc-fix-real-path_resolv.conf.patch \
            file://poky-fc-fix-real-path_login.patch \
           "

# Specific policy for Poky
SRC_URI += "file://poky-policy-add-syslogd_t-to-trusted-object.patch \
            file://poky-policy-add-rules-for-var-log-symlink.patch \
            file://poky-policy-add-rules-for-tmp-symlink.patch \
            file://poky-policy-add-rules-for-bsdpty_device_t.patch \
            file://poky-policy-don-t-audit-tty_device_t.patch \
            file://poky-policy-allow-dbusd-to-setrlimit-itself.patch \
            file://poky-policy-allow-dbusd-to-exec-shell-commands.patch \
            file://poky-policy-allow-nfsd-to-exec-shell-commands.patch \
            file://poky-policy-allow-setfiles_t-to-read-symlinks.patch \
            file://poky-policy-fix-new-SELINUXMNT-in-sys.patch \
           "

# Other policy fixes 
SRC_URI += "file://poky-policy-fix-xconsole_device_t-as-a-dev_node.patch \
           "

include refpolicy_common.inc
