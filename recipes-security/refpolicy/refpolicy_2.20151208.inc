SRC_URI = "https://raw.githubusercontent.com/wiki/TresysTechnology/refpolicy/files/refpolicy-${PV}.tar.bz2;"
SRC_URI[md5sum] = "7b1ca12e9ea0254508391559cb8f2c41"
SRC_URI[sha256sum] = "2dd2f45a7132137afe8302805c3b7839739759b9ab73dd1815c01afe34ac99de"

FILESEXTRAPATHS_prepend := "${THISDIR}/refpolicy-2.20151208:"

# Fix file contexts for Poky
SRC_URI += "file://poky-fc-subs_dist.patch \
            file://poky-fc-update-alternatives_sysvinit.patch \
            file://poky-fc-update-alternatives_sysklogd.patch \
            file://poky-fc-update-alternatives_hostname.patch \
            file://poky-fc-fix-real-path_resolv.conf.patch \
            file://poky-fc-fix-real-path_login.patch \
            file://poky-fc-fix-real-path_shadow.patch \
            file://poky-fc-fix-bind.patch \
            file://poky-fc-clock.patch \
            file://poky-fc-corecommands.patch \
            file://poky-fc-dmesg.patch \
            file://poky-fc-fstools.patch \
            file://poky-fc-iptables.patch \
            file://poky-fc-mta.patch \
            file://poky-fc-netutils.patch \
            file://poky-fc-nscd.patch \
            file://poky-fc-screen.patch \
            file://poky-fc-ssh.patch \
            file://poky-fc-su.patch \
            file://poky-fc-sysnetwork.patch \
            file://poky-fc-udevd.patch \
            file://poky-fc-rpm.patch \
            file://poky-fc-ftpwho-dir.patch \
            file://poky-fc-fix-real-path_su.patch \
            file://refpolicy-update-for_systemd.patch \
           "

# Specific policy for Poky
SRC_URI += "file://poky-policy-add-syslogd_t-to-trusted-object.patch \
            file://poky-policy-add-rules-for-var-log-symlink.patch \
            file://poky-policy-add-rules-for-var-log-symlink-apache.patch \
            file://poky-policy-add-rules-for-var-log-symlink-audisp_remote_t.patch \
            file://poky-policy-add-rules-for-syslogd_t-symlink.patch \
            file://poky-policy-add-rules-for-var-cache-symlink.patch \
            file://poky-policy-add-rules-for-tmp-symlink.patch \
            file://poky-policy-add-rules-for-bsdpty_device_t.patch \
            file://poky-policy-don-t-audit-tty_device_t.patch \
            file://poky-policy-allow-nfsd-to-exec-shell-commands.patch \
            file://poky-policy-fix-nfsd_t-to-mount_nfsd_fs_t.patch \
            file://poky-policy-allow-setfiles_t-to-read-symlinks.patch \
            file://poky-policy-fix-new-SELINUXMNT-in-sys.patch \
            file://poky-policy-allow-sysadm-to-run-rpcinfo.patch \
           "

# Other policy fixes 
SRC_URI += " \
            file://poky-policy-fix-seutils-manage-config-files.patch \
            file://poky-policy-fix-setfiles-statvfs-get-file-count.patch \
            file://poky-policy-fix-dmesg-to-use-dev-kmsg.patch \
            file://ftp-add-ftpd_t-to-mlsfilewrite.patch \
           "

include refpolicy_common.inc
