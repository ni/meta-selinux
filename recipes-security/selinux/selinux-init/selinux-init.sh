#!/bin/sh

/usr/sbin/selinuxenabled 2>/dev/null || exit 0

CHCON=/usr/bin/chcon
MATCHPATHCON=/usr/sbin/matchpathcon
RESTORECON=/sbin/restorecon
SECON=/usr/bin/secon
SETENFORCE=/usr/sbin/setenforce

for i in ${CHCON} ${MATCHPATHCON} ${RESTORECON} ${SECON} ${SETENFORCE}; do
	test -x $i && continue
	echo "$i is missing in the system."
	echo "Please add \"selinux=0\" in the kernel command line to disable SELinux."
	exit 1
done

check_rootfs()
{
	${CHCON} `${MATCHPATHCON} -n /` / >/dev/null 2>&1 && return 0
	echo ""
	echo "* SELinux requires the root '/' filesystem support extended"
	echo "  filesystem attributes (XATTRs).  It does not appear that this"
	echo "  filesystem has extended attribute support or it is not enabled."
	echo ""
	echo "  - To continue using SELinux you will need to enable extended"
	echo "    attribute support on the root device."
	echo ""
	echo "  - To disable SELinux, please add \"selinux=0\" in the kernel"
	echo "    command line."
	echo ""
	echo "* Halting the system now."
	/sbin/shutdown -f -h now
}

# sysvinit firstboot relabel placeholder HERE

exit 0
