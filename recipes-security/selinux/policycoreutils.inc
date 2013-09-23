PRINC = "3"

SUMMARY = "SELinux policy core utilities"
DESCRIPTION = "policycoreutils contains the policy core utilities that are required \
for basic operation of a SELinux system.  These utilities include \
load_policy to load policies, setfiles to label filesystems, newrole \
to switch roles, and run_init to run /etc/init.d scripts in the proper \
context."
SECTION = "base"
LICENSE = "GPLv2+"

SRC_URI += "${@base_contains('DISTRO_FEATURES', 'pam', '${PAM_SRC_URI}', '', d)}"

PAM_SRC_URI = "file://pam.d/newrole \
               file://pam.d/run_init \
              "

DEPENDS += "libsepol libselinux libsemanage"
EXTRA_DEPENDS = "libcap-ng libcgroup setools"
DEPENDS += "${@['', '${EXTRA_DEPENDS}']['${PN}' != '${BPN}-native']}"

inherit selinux
DEPENDS += "${@target_selinux(d, 'libpam audit')}"

RDEPENDS_${BPN} += "\
	libselinux-python \
	libsemanage-python \
	sepolgen \
	"
RDEPENDS_${BPN} += "\
	python \
	python-unixadmin \
	python-shell \
	python-crypt \
	python-subprocess \
	python-syslog \
	python-textutils \
	python-ipy \
	"

RDEPENDS_${BPN} += "setools setools-libs ${BPN}-python"

WARN_QA := "${@oe_filter_out('unsafe-references-in-scripts', '${WARN_QA}', d)}"
ERROR_QA := "${@oe_filter_out('unsafe-references-in-scripts', '${ERROR_QA}', d)}"

inherit pythonnative

PACKAGES =+ "${PN}-python ${PN}-sandbox system-config-selinux"
FILES_${PN}-python = "${libdir}/python${PYTHON_BASEVERSION}/site-packages/seobject.py* \
	${libdir}/python${PYTHON_BASEVERSION}/site-packages/sepolicy*.egg-info \
	${libdir}/python${PYTHON_BASEVERSION}/site-packages/sepolicy/*"
FILES_${PN}-dbg += "${libdir}/python${PYTHON_BASEVERSION}/site-packages/sepolicy/.debug/*"
FILES_${PN}-sandbox = "${datadir}/sandbox/*"
FILES_${PN}-sandbox += "${bindir}/sandbox"
FILES_${PN}-sandbox += "${sbindir}/seunshare"
FILES_system-config-selinux = " \
    ${bindir}/sepolgen \
    ${datadir}/system-config-selinux/* \
"

export STAGING_INCDIR
export STAGING_LIBDIR
export BUILD_SYS
export HOST_SYS

AUDITH="`ls ${STAGING_INCDIR}/libaudit.h >/dev/null 2>&1 && echo /usr/include/libaudit.h `"
PAMH="`ls ${STAGING_INCDIR}/security/pam_appl.h >/dev/null 2>&1 && echo /usr/include/security/pam_appl.h `"
EXTRA_OEMAKE += "${@target_selinux(d, 'PAMH=${PAMH} AUDITH=${AUDITH}', 'PAMH= AUDITH= ')} INOTIFYH=n"
EXTRA_OEMAKE += "PREFIX=${D}"
EXTRA_OEMAKE += "INITDIR=${D}/etc/init.d"

BBCLASSEXTEND = "native"

PCU_NATIVE_CMDS = "setfiles semodule_package semodule semodule_link semodule_expand semodule_deps"

do_compile_virtclass-native() {
	for PCU_CMD in ${PCU_NATIVE_CMDS} ; do
		oe_runmake -C $PCU_CMD \
			INCLUDEDIR='${STAGING_INCDIR}' \
			LIBDIR='${STAGING_LIBDIR}'
	done
}

do_compile_prepend() {
	export PYTHON=python
	export PYLIBVER='python${PYTHON_BASEVERSION}'
	export PYTHON_CPPFLAGS="-I${STAGING_INCDIR}/${PYLIBVER}"
	export PYTHON_LDFLAGS="${STAGING_LIBDIR}/lib${PYLIBVER}.so"
	export PYTHON_SITE_PKG="${libdir}/${PYLIBVER}/site-packages"
}

do_install_prepend() {
	export PYTHON=python
	export SEMODULE_PATH=${sbindir}
}

do_install_virtclass-native() {
	for PCU_CMD in ${PCU_NATIVE_CMDS} ; do
	     oe_runmake -C $PCU_CMD install \
			DESTDIR="${D}" \
			PREFIX="${D}/${prefix}" \
			SBINDIR="${D}/${base_sbindir}"
	done
}

do_install_append_class-target() {
	if [ -e ${WORKDIR}/pam.d ]; then
		install -d ${D}${sysconfdir}/pam.d/
		install -m 0644 ${WORKDIR}/pam.d/* ${D}${sysconfdir}/pam.d/
	fi
}
