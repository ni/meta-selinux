SUMMARY = "SELinux dbus service files"
DESCRIPTION = "\
Provide SELinux dbus service files and scripts."
SECTION = "base"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=393a5ca445f6965873eca0259a17f833"

require selinux_common.inc

S = "${WORKDIR}/git/dbus"

RDEPENDS:${PN} += "python3-core selinux-python-sepolicy"

FILES:${PN} += "\
        ${datadir}/system-config-selinux/selinux_server.py \
        ${datadir}/polkit-1/actions/org.selinux.policy \
        ${datadir}/dbus-1/system-services/org.selinux.service \
"
