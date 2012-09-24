SUMMARY = "Policy analysis tools for SELinux"
DESCRIPTION = "\
SETools is a collection of graphical tools, command-line tools, and \
libraries designed to facilitate SELinux policy analysis. \
\n\
This meta-package depends upon the main packages necessary to run \
SETools."
SECTION = "base"
LICENSE = "GPLv2 & LGPLv2.1"
PR = "r1"

SRC_URI = "http://oss.tresys.com/projects/setools/chrome/site/dists/setools-${PV}/setools-${PV}.tar.bz2;"
SRC_URI[md5sum] = "0377d7a06028825434cd7b41a80865a5"
SRC_URI[sha256sum] = "2bfa0918746bdcc910b16b26a51109a4ffd07404c306141ada584cb36e3c895a"

SRC_URI += "file://setools-Add-seinfo-and-sesearch-python-bindings.patch"
SRC_URI += "file://setools-seinfo-should-exit-with-correct-errno.patch"
SRC_URI += "file://setools-neverallow-rules-all-always-fail.patch"
SRC_URI += "file://setools-Fix-man-pages-and-getoptions.patch"
SRC_URI += "file://setools-Fix-sepol-calls-to-work-with-latest-libsepol.patch"
SRC_URI += "file://setools-Changes-to-support-named-file_trans-rules.patch"
SRC_URI += "file://setools-Remove-unused-variables.patch"
SRC_URI += "file://setools-Fix-output-to-match-policy-lines.patch"

SRC_URI += "file://setools-Don-t-check-selinux-policies-if-disabled.patch"
SRC_URI += "file://setools-configure-ac.patch"
SRC_URI += "file://setools-cross-ar.patch"

SRC_URI += "file://setools-Fix-test-bug-for-unary-operator.patch"
SRC_URI += "file://setools-Fix-python-setools-Makefile.am-for-cross.patch"

LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=26035c503c68ae1098177934ac0cc795 \
                    file://${S}/COPYING.GPL;md5=751419260aa954499f7abaabaa882bbe \
                    file://${S}/COPYING.LGPL;md5=fbc093901857fcd118f065f900982c24"

DEPENDS += "python libsepol libselinux libxml2"

PACKAGES += "${PN}-libs ${PN}-console"

FILES_${PN}-dbg += "\
	${libdir}/python${PYTHON_BASEVERSION}/site-packages/setools/.debug \
	"

FILES_${PN}-libs = "\
	${libdir}/libqpol.so.* \
	${libdir}/libapol.so.* \
	${libdir}/libpoldiff.so.* \
	${libdir}/libsefs.so.* \
	${libdir}/libseaudit.so.* \
	${libdir}/python${PYTHON_BASEVERSION}/site-packages/*.egg-info \
	${libdir}/python${PYTHON_BASEVERSION}/site-packages/setools/*.so* \
	${libdir}/python${PYTHON_BASEVERSION}/site-packages/setools/*.py* \
	"

FILES_${PN}-console = "\
	${bindir}/seinfo \
	${bindir}/sesearch \
	${bindir}/indexcon \
	${bindir}/findcon \
	${bindir}/replcon \
	${bindir}/sechecker \
	${bindir}/sediff \
	${datadir}/setools-3.3/sechecker-profiles/* \
	${datadir}/setools-3.3/sechecker_help.txt \
	${datadir}/setools-3.3/sediff_help.txt \
	${datadir}/setools-3.3/sediffx* \
	${mandir}/man1/findcon.1.gz \
	${mandir}/man1/indexcon.1.gz \
	${mandir}/man1/replcon.1.gz \
	${mandir}/man1/sechecker.1.gz \
	${mandir}/man1/sediff.1.gz \
	${mandir}/man1/seinfo.1.gz \
	${mandir}/man1/sesearch.1.gz \
	"

inherit autotools pythonnative

# need to export these variables for python-config to work
export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

do_configure() {
        autoreconf --force --install 
	export ac_cv_policydb_version_max=26
	export PYTHON=python
	export PYLIBVER='python${PYTHON_BASEVERSION}'
	export PYTHON_CPPFLAGS="-I${STAGING_INCDIR}/${PYLIBVER}"
	export PYTHON_LDFLAGS="-L${STAGING_LIBDIR}/${PYLIBVER} -l${PYLIBVER}"
	export PYTHON_SITE_PKG="${libdir}/${PYLIBVER}/site-packages"
        oe_runconf --disable-bwidget-check --disable-selinux-check \
		--disable-swig-python --disable-swig-java --disable-swig-tcl \
		--disable-profiling --disable-gui --with-tk=no --with-tcl=no \
		--with-sepol-devel=${STAGING_LIBDIR}/.. \
		--with-selinux-devel=${STAGING_LIBDIR}/.. 
}

do_install_append() {
	rm -f ${D}/${libdir}/*.a
}
