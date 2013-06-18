SRCREV = "3f52a123af40bae33bde2a1f2ecfb2320b61f9ad"

SRC_URI = "git://oss.tresys.com/git/selinux.git;protocol=http"
SRC_URI[md5sum] = "4ec64a0d24aaa77c80b86e74d271e464"
SRC_URI[sha256sum] = "9c8a8643c9a4dd0eb76fcda1420d636b750b84b27656c6f8bc6886a829d7e520"

S = "${WORKDIR}/git/${BPN}"

include selinux_common.inc

DEFAULT_PREFERENCE = "-1"
