PR .= ".1"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://volatiles.04_bind"

do_install_append() {
        install -d ${D}${sysconfdir}/default/volatiles
        install -m 0644 ${WORKDIR}/volatiles.04_bind ${D}${sysconfdir}/default/volatiles/volatiles.04_bind
}
