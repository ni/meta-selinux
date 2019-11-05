SUMMARY = "SELinux autorelabel script"
DESCRIPTION = "\
Script to reset SELinux labels on the root file system when /.autorelabel \
file is present.\
"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

${PN}_RDEPENDS = " \
    policycoreutils-setfiles \
"

SRC_URI = "file://${BPN}.sh \
		file://${BPN}.service \
	"

INITSCRIPT_PARAMS = "start 01 S ."

require selinux-initsh.inc

do_install_append() {
	if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
		install -d ${D}${bindir}
		install -m 0755 ${WORKDIR}/${SELINUX_SCRIPT_SRC}.sh ${D}${bindir}
		sed -i -e '/.*HERE$/d' ${D}${bindir}/${SELINUX_SCRIPT_SRC}.sh
		echo "# first boot relabelling" > ${D}/.autorelabel
	fi
}
