# If selinux enabled, disable handlers to rw command history file
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit selinux

