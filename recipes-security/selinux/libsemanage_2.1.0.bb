SUMMARY = "SELinux binary policy manipulation library"
DESCRIPTION = "libsemanage provides an API for the manipulation of SELinux binary policies. \
It is used by checkpolicy (the policy compiler) and similar tools, as well \
as by programs like load_policy that need to perform specific transformations \
on binary policies such as customizing policy boolean settings."
SECTION = "base"
PR = "r1"
LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

include selinux.inc
inherit lib_package

SRC_URI[md5sum] = "d97b0700138dfcc0a9db55a26adffc70"
SRC_URI[sha256sum] = "004c05e32326b1658a85743a950b322d509032dc7c7f652989d7a20ec3652d0f"

DEPENDS += "libsepol libselinux ustr bzip2"

EXTRA_OEMAKE += "INCLUDEDIR='${STAGING_INCDIR}' LIBDIR='${STAGING_LIBDIR}' PYLIBVER='python${PYTHON_BASEVERSION}' PYINC='${STAGING_INCDIR}/$(PYLIBVER)' PYLIB='${STAGING_LIBDIR}/$(PYLIBVER)' PYTHONLIBDIR='$(PYLIB)'"

do_compile() {
	oe_runmake all pywrap
}

do_install_append() {
	rm ${D}${libdir}/libsemanage.so
	ln -s libsemanage.so.1 ${D}${base_libdir}/libsemanage.so

	count=0 ; while [ -n "$libdir" -a "$libdir" != "." -a "$libdir" != "/" ]; do count=$(expr $count + 1); libdir=`dirname $libdir` ; done

	relpath=""
	newcount=0 ; while [ $newcount -lt $count ]; do if [ $newcount -ne 0 ]; then relpath+="/" ; fi ; relpath+=".." ; newcount=$(expr $newcount + 1) ; done

	ln -sf $relpath/${base_libdir}/libsemanage.so.1 ${D}${libdir}/libsemanage.so
}

