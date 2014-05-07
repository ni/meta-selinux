FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# Enable selinux support in the kernel if the feature is enabled
SRC_URI += "${@base_contains('DISTRO_FEATURES', 'selinux', 'file://selinux.cfg', '', d)}"

# For inconsistent kallsyms data bug on ARM
# http://lists.infradead.org/pipermail/linux-arm-kernel/2012-March/thread.html#89718 
EXTRA_OEMAKE += "${@base_contains('TARGET_ARCH', 'arm', ' KALLSYMS_EXTRA_PASS=1', '', d)}"
