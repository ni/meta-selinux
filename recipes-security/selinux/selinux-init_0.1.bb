SUMMARY = "SELinux init script"
DESCRIPTION = "\
SELinux start up stuff for Yocto. \
"

SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

${PN}_RDEPENDS = " \
    coreutils \
    libselinux-bin \
    policycoreutils-secon \
    policycoreutils-setfiles \
"

S = "${WORKDIR}"

SRC_URI = "file://selinux-init.sh"

inherit update-rc.d

INITSCRIPT_NAME = "0selinux-init"
INITSCRIPT_PARAMS = "start 00 S ."

CONFFILES_${PN} += "${sysconfdir}/init.d/0selinux-init"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install () {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/selinux-init.sh ${D}${sysconfdir}/init.d/0selinux-init
}

sysroot_stage_all_append () {
	sysroot_stage_dir ${D}${sysconfdir} ${SYSROOT_DESTDIR}${sysconfdir}
}
