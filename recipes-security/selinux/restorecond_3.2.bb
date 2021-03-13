SUMMARY = "Daemon to watch for file creation and set default file context"
DESCRIPTION = "\
The restorecond daemon uses inotify to watch files listed in the \
/etc/selinux/restorecond.conf, when they are created, this daemon \
will make sure they have the correct file context associated with \
the policy."
SECTION = "base"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=393a5ca445f6965873eca0259a17f833"

require selinux_common.inc

inherit systemd update-rc.d

DEPENDS += "libsepol libselinux libpcre dbus-glib glib-2.0 pkgconfig-native"

EXTRA_OEMAKE += "SYSTEMDSYSTEMUNITDIR=${systemd_system_unitdir} \
                 SYSTEMDUSERUNITDIR=${systemd_user_unitdir} \
                "

S = "${WORKDIR}/git/restorecond"

FILES_${PN} += "${datadir}/dbus-1/services/org.selinux.Restorecond.service \
                ${systemd_user_unitdir}/* \
               "

SYSTEMD_SERVICE_restorecond = "restorecond.service"
INITSCRIPT_PACKAGES = "restorecond"
INITSCRIPT_NAME_restorecond = "restorecond"
INITSCRIPT_PARAMS_restorecond = "defaults"

do_install_append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'false', 'true', d)}; then
        # remove /usr/lib/systemd/user
        rm -rf ${D}${nonarch_libdir}
    fi
}
