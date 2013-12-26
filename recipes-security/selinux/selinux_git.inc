SRCREV = "edc2e99687b050d5be21a78a66d038aa1fc068d9"

SRC_URI = "git://oss.tresys.com/git/selinux.git;protocol=http"

S = "${WORKDIR}/git/${BPN}"

include selinux_common.inc

DEFAULT_PREFERENCE = "-1"
