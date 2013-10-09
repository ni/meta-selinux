DESCRIPTION = "SELinux policycoreutils packagegroup"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420 \
"
PR = "r0"

PACKAGES = "\
    ${PN} \
"

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} = "\
	policycoreutils-audit2allow \
	policycoreutils-chcat \
	policycoreutils-fixfiles \
	policycoreutils-genhomedircon \
	policycoreutils-loadpolicy \
	policycoreutils-newrole \
	policycoreutils-python \
	policycoreutils-runinit \
	policycoreutils-sandbox \
	policycoreutils-secon \
	policycoreutils-semanage \
	policycoreutils-semodule \
	policycoreutils-semodule-deps \
	policycoreutils-semodule-expand \
	policycoreutils-semodule-link \
	policycoreutils-semodule-package \
	policycoreutils-sepolgen-ifgen \
	policycoreutils-sepolicy \
	policycoreutils-sestatus \
	policycoreutils-setfiles \
	policycoreutils-setsebool \
	system-config-selinux \
"
