SRC_URI = "http://oss.tresys.com/files/refpolicy/refpolicy-${PV}.tar.bz2;"
SRC_URI[md5sum] = "618a24cfed3b3ee09084fb2c179de92e"
SRC_URI[sha256sum] = "6df77faf62f73bd1f6e3bfca3fa2f77cdfd2cada94a7dcc4816ed9bbcf3545dc"

FILESEXTRAPATHS_prepend := "${THISDIR}/refpolicy-2.20120215:"
SRC_URI += "file://poky-fc-update-alternatives_sysvinit.patch \
	    file://poky-fc-etc_init.d.patch \
	    file://fix-mount-to-write-mountpoints-dirs.patch \
	    "

include refpolicy_common.inc
