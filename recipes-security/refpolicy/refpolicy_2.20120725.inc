SRC_URI = "http://oss.tresys.com/files/refpolicy/refpolicy-${PV}.tar.bz2;"
SRC_URI[md5sum] = "8aaa8a23cc1b7b7045f6f134e879ddb7"
SRC_URI[sha256sum] = "7cd46ed908a4001368e6509d93e306ec6c9af2bfa6b70db88c9eaaefe257c635"

FILESEXTRAPATHS_prepend := "${THISDIR}/refpolicy-${PV}:"
SRC_URI += "file://poky-fc-update-alternatives_sysvinit.patch \
	    "

include refpolicy_common.inc
