SUMMARY = "SELinux init script"
DESCRIPTION = "\
SELinux start up stuff for Yocto. \
"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

${PN}_RDEPENDS = " \
    coreutils \
    libselinux-bin \
    policycoreutils-secon \
    policycoreutils-setfiles \
"

SRC_URI = "file://${BPN}.sh"
SELINUX_SCRIPT_DST = "0${BPN}"

require selinux-initsh.inc
