DESCRIPTION = "SELinux policycoreutils packagegroup"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420 \
"
PR = "r0"

PACKAGES = "\
    ${PN} \
"

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} = "\
	policycoreutils-fixfiles \
	policycoreutils-genhomedircon \
	policycoreutils-loadpolicy \
	policycoreutils-newrole \
	policycoreutils-runinit \
	policycoreutils-secon \
	policycoreutils-semodule \
	policycoreutils-sestatus \
	policycoreutils-setfiles \
	policycoreutils-setsebool \
	policycoreutils-hll \
	semodule-utils-semodule-deps \
	semodule-utils-semodule-expand \
	semodule-utils-semodule-link \
	semodule-utils-semodule-package \
	selinux-python-audit2allow \
	selinux-python-sepolgen-ifgen \
	selinux-python-semanage \
	selinux-python-sepolicy \
	selinux-python-chcat \
	selinux-python \
	selinux-sandbox \
	selinux-dbus \
	selinux-gui \
"
