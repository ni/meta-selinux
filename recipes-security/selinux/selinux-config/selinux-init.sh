#!/bin/sh

/usr/sbin/selinuxenabled 2>/dev/null || exit 0

# Because /dev/console is not relabeled by kernel, many commands
# would can not use it, including restorecon.
if [ -x /usr/bin/chcon ]; then
       /usr/bin/chcon -t null_device_t /dev/null
       /usr/bin/chcon -t console_device_t /dev/console
fi


# If /.autorelabel placed, the whole file system should be relabeled
test ! -x /sbin/fixfiles ||
if [ -f /.autorelabel ]; then
	echo "Checking SELinux security contexts:"
	echo " * /.autorelabel placed, filesystem will be relabeled..."
	/sbin/fixfiles -F -f relabel
	/bin/rm -f /.autorelabel
	echo " * Relabel done, rebooting the system."
	/sbin/reboot -f
fi

# If first booting, the security context type of init would be
# "kernel_t", and the whole file system should be relabeled.
test ! -x /sbin/restorecon ||
if [ "`/usr/bin/secon -t --pid 1`" = "kernel_t" ]; then
	echo "Checking SELinux security contexts:"
	echo " * First booting, filesystem will be relabeled..."
	test -x /etc/init.d/auditd && /etc/init.d/auditd start
	/usr/sbin/setenforce 0
	/sbin/restorecon -R /
	/sbin/restorecon /
	echo " * Relabel done, rebooting the system."
	/sbin/reboot -f
fi

# Now, we should relabel /dev for most services.
test ! -x /sbin/restorecon || /sbin/restorecon -R /dev
