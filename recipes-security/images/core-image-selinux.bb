DESCRIPTION = "Image with SELinux support" 

IMAGE_FEATURES += "apps-console-core ssh-server-openssh"

LICENSE = "MIT"

IMAGE_INSTALL = "\
	${CORE_IMAGE_BASE_INSTALL} \
	task-core-basic \
	task-core-selinux \
"   

inherit core-image
