SUMMARY = "Micro String API - for C"
DESCRIPTION = "Micro string library, very low overhead from plain strdup() (Ave. 44% for \
0-20B strings). Very easy to use in existing C code. At it's simplest you can \
just include a single header file into your .c and start using it."

SECTION = "base"
PR = "r1"
LICENSE = "MIT | LGPLv2+ | BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c79c6e2ae13418d16d7dc82df960a1e7 \
		    file://LICENSE_BSD;md5=ceb504b0b6471e76cc9cb32cfb150f3c \
		    file://LICENSE_LGPL;md5=d8045f3b8f929c1cb29a1e3fd737b499 \
		    file://LICENSE_MIT;md5=c61e779b782608472bd87593c3c3916f"

SRC_URI = "http://www.and.org/ustr/1.0.4/ustr-1.0.4.tar.bz2 \
    file://ustr-makefile-fix.patch;patch=1 \
    file://ustr-fix__va_copy-not-defined.patch;patch=2"
SRC_URI[md5sum] = "93147d9f0c9765d4cd0f04f7e44bdfce"
SRC_URI[sha256sum] = "3daf6eae9f78de1e872c0b2b83cce35515b94d4bb8a074e48f331fd99e1fc2c4"

inherit lib_package
inherit siteinfo

FILES_${PN} = "${libdir}/libustr-1.0.so.*"

FILES_${PN}-dev += "${bindir}/ustr-import \
			${libexecdir}/ustr-${PV}/ustr-import-* \
			${datadir}/.gdb_init \
			${datadir}/ustr-${PV} \
			${mandir}"

FILES_${PN}-dbg += "${libdir}/libustr-debug* \
			${libdir}/pkgconfig/*-debug.* \
			${base_libdir}/debug/${libdir}"

EXTRA_OEMAKE_virtclass-native = "prefix=/usr"

do_compile() {
	oe_runmake all-shared
}

do_install() {
	oe_runmake install-multilib-linux  \
		mlib=${SITEINFO_BITS} \
		DESTDIR=${D} LDCONFIG=/bin/true
	mkdir -p ${D}/${datadir}/doc/${PN}-${PV}
	install ChangeLog ${D}/${datadir}/doc/${PN}-${PV}
	install LICENSE* ${D}/${datadir}/doc/${PN}-${PV}
	install README ${D}/${datadir}/doc/${PN}-${PV}
	install NEWS ${D}/${datadir}/doc/${PN}-${PV}
	mv ${D}/${docdir}/ustr-devel-${PV}/strdup\ vs.\ ustr.gnumeric \
		${D}/${docdir}/ustr-devel-${PV}/strdup_vs._ustr.gnumeric
}

BBCLASSEXTEND = "native"
