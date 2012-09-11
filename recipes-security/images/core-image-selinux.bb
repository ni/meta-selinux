DESCRIPTION = "Image with SELinux support" 

IMAGE_FEATURES += "splash ssh-server-openssh"

LICENSE = "MIT"

IMAGE_INSTALL = "\
	${CORE_IMAGE_BASE_INSTALL} \
	packagegroup-core-basic \
	task-core-selinux \
"   

inherit core-image
