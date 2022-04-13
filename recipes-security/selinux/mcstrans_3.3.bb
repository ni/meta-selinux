
SUMMARY = "Daemon to translate SELinux MCS/MLS sensitivity labels"
DESCRIPTION = "\
mcstrans provides an translation daemon to translate SELinux categories \
from internal representations to user defined representation."
SECTION = "base"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

require selinux_common.inc

inherit systemd update-rc.d

SRC_URI += "file://mcstrans-de-bashify.patch \
            file://mcstrans-fix-the-init-script.patch \
           "

DEPENDS += "libsepol libselinux libcap"

EXTRA_OEMAKE += "SBINDIR=${base_sbindir} \
                 INITDIR=${sysconfdir}/init.d \
                 SYSTEMDDIR=${systemd_unitdir} \
                "

S = "${WORKDIR}/git/mcstrans"

do_install:append() {
    install -d ${D}${sbindir}
    install -m 755 utils/untranscon ${D}${sbindir}/
    install -m 755 utils/transcon ${D}${sbindir}/

    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${sysconfdir}/tmpfiles.d
        echo "d ${localstatedir}/run/setrans - - - -" \
            > ${D}${sysconfdir}/tmpfiles.d/setrans.conf
    else
        install -d ${D}${sysconfdir}/default/volatiles
        echo "d root root 0755 /var/run/setrans none" \
            >${D}${sysconfdir}/default/volatiles/80_mcstrans
    fi
    install -d ${D}${datadir}/mcstrans
    cp -r share/* ${D}${datadir}/mcstrans/.
}

SYSTEMD_SERVICE:mcstrans = "mcstrans.service"
INITSCRIPT_PACKAGES = "mcstrans"
INITSCRIPT_NAME:mcstrans = "mcstrans"
INITSCRIPT_PARAMS:mcstrans = "defaults"

pkg_postinst:mcstrans () {
    if [ -z "$D" ]; then
        if command -v systemd-tmpfiles >/dev/null; then
            systemd-tmpfiles --create ${sysconfdir}/tmpfiles.d/setrans.conf
        elif [ -e ${sysconfdir}/init.d/populate-volatile.sh ]; then
            ${sysconfdir}/init.d/populate-volatile.sh update
        fi
    fi
}
