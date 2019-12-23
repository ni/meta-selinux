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
		echo "# first boot relabelling" > ${D}/.autorelabel
	fi
}
