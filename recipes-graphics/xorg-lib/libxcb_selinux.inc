inherit enable-selinux
PACKAGECONFIG[selinux] = "--enable-selinux,--disable-selinux,libselinux"

PACKAGES += "${PN}-xselinux"
FILES:${PN}-xselinux += "${libdir}/libxcb-xselinux.so.*"
