#!/bin/sh

/usr/sbin/selinuxenabled 2>/dev/null || exit 0

FIXFILES=/sbin/fixfiles
SETENFORCE=/usr/sbin/setenforce

for i in ${FIXFILES} ${SETENFORCE}; do
	test -x $i && continue
	echo "$i is missing in the system."
	echo "Please add \"selinux=0\" in the kernel command line to disable SELinux."
	exit 1
done

# If /.autorelabel placed, the whole file system should be relabeled
if [ -f /.autorelabel ]; then
	echo "SELinux: /.autorelabel placed, filesystem will be relabeled..."
	${SETENFORCE} 0
	${FIXFILES} -F -f relabel
	/bin/rm -f /.autorelabel
	echo " * Relabel done, rebooting the system."
	/sbin/reboot
fi

exit 0
