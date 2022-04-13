SUMMARY = "SELinux GUI tools"
DESCRIPTION = "\
Provide SELinux Management tool (system-config-selinux) and SELinux \
Policy Generation Tool (selinux-polgengui)"
SECTION = "base"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=393a5ca445f6965873eca0259a17f833"

require selinux_common.inc

S = "${WORKDIR}/git/gui"

RDEPENDS:${PN} += "python3-core"

FILES:${PN} += " \
        ${datadir}/system-config-selinux/* \
        ${datadir}/icons/hicolor/* \
        ${datadir}/polkit-1/actions/org.selinux.config.policy \
"
