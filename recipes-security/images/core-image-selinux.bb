DESCRIPTION = "Image with SELinux support" 

IMAGE_FEATURES += "splash ssh-server-openssh"

LICENSE = "MIT"

IMAGE_INSTALL = "\
	${CORE_IMAGE_BASE_INSTALL} \
	util-linux-agetty \
	packagegroup-core-basic \
	packagegroup-core-selinux \
"   

inherit core-image
