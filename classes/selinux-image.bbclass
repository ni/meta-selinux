selinux_set_labels() {
    if [ -f ${IMAGE_ROOTFS}/${sysconfdir}/selinux/config ]; then
        POL_TYPE=$(sed -n -e "s&^SELINUXTYPE[[:space:]]*=[[:space:]]*\([0-9A-Za-z_]\+\)&\1&p" ${IMAGE_ROOTFS}/${sysconfdir}/selinux/config)
        if ! setfiles -m -r ${IMAGE_ROOTFS} ${IMAGE_ROOTFS}/${sysconfdir}/selinux/${POL_TYPE}/contexts/files/file_contexts ${IMAGE_ROOTFS}
        then
            bbwarn "Failed to set security contexts. Restoring security contexts will run on first boot."
            echo "# first boot relabelling" > ${IMAGE_ROOTFS}/.autorelabel
        fi
    fi
}

# The selinux_set_labels function should run as late as possible. Append
# it to IMAGE_PREPROCESS_COMMAND in RecipePreFinalise event handler,
# this ensures it is the last function in IMAGE_PREPROCESS_COMMAND.
python selinux_setlabels_handler() {
    if not d or 'selinux' not in d.getVar('DISTRO_FEATURES').split():
        return

    if d.getVar('FIRST_BOOT_RELABEL') == '1':
        return

    d.appendVar('IMAGE_PREPROCESS_COMMAND', ' selinux_set_labels; ')
    d.appendVarFlag('do_image', 'depends', ' policycoreutils-native:do_populate_sysroot')
}

addhandler selinux_setlabels_handler
selinux_setlabels_handler[eventmask] = "bb.event.RecipePreFinalise"

inherit core-image
