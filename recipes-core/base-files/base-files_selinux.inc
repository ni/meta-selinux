REFPOLICY_TYPE = "${@d.getVar('PREFERRED_PROVIDER_virtual/refpolicy').split('-')[1] or ''}"

do_install:append () {
    if [ -n "${REFPOLICY_TYPE}" ]; then
        if [ "${REFPOLICY_TYPE}" = "standard" ]; then
            sed -i 's/\s*\/var\/volatile\s*tmpfs\s*defaults/&,rootcontext=system_u:object_r:var_t/' \
                ${D}${sysconfdir}/fstab
        else
            sed -i 's/\s*\/var\/volatile\s*tmpfs\s*defaults/&,rootcontext=system_u:object_r:var_t:s0/' \
                ${D}${sysconfdir}/fstab
        fi
    fi
}
