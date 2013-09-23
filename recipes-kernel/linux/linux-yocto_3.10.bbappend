PRINC = "1"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# For inconsistent kallsyms data bug on ARM
# http://lists.infradead.org/pipermail/linux-arm-kernel/2012-March/thread.html#89718 
EXTRA_OEMAKE += "${@base_contains('TARGET_ARCH', 'arm', ' KALLSYMS_EXTRA_PASS=1', '', d)}"
