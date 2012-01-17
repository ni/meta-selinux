SUMMARY = "Python modules for supporting various SELinux utilities."
DESCRIPTION = "Python modules for supporting various SELinux utilities."
SECTION = "base"
PR = "r1"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

include selinux.inc

SRC_URI[md5sum] = "efc281a45fde093c6506853617594ce6"
SRC_URI[sha256sum] = "9f2f6b07912aee3ecf32060ea09bab6d8d9cfe492638b28f058b4490b44c8e78"

EXTRA_OEMAKE += "PYTHONLIBDIR='${libdir}/python${PYTHON_BASEVERSION}/site-packages'"

DEPENDS += "python"

FILES_${PN} += "${libdir}/python${PYTHON_BASEVERSION}/site-packages"
