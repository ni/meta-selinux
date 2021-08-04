FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

do_install:append () {
	cat <<-EOF >> ${D}${sysconfdir}/init.d/populate-volatile.sh
touch /var/log/lastlog
test ! -x /sbin/restorecon || /sbin/restorecon -iRF /var/volatile/ /var/lib /run \
    /etc/resolv.conf /etc/adjtime /tmp /var/tmp /var/log /var/lock /var/run
EOF
	sed -i '/mount -n -o remount,$rootmode/i\test ! -x /sbin/restorecon || /sbin/restorecon -iRF /run' \
	    ${D}${sysconfdir}/init.d/checkroot.sh
}
