do_install_append () {
	# This code creates libpcre for both the dev machine (SDK native)
	# and for cross-compiling (machine arch). For Linux (SDK Linux native
	# + all machine arch), symlinks to the .so files have to be created,
	# but not for the Windows SDK native.
	if [ ${TARGET_OS} != "mingw32" ]; then
		if [ ! ${D}${libdir} -ef ${D}${base_libdir} -a -e ${D}${libdir}/libpcre.so ]; then
			realsofile=`readlink ${D}${libdir}/libpcre.so`
			mkdir -p ${D}/${base_libdir}/
			mv -f ${D}${libdir}/libpcre.so.* ${D}${base_libdir}/
			relpath=${@os.path.relpath("${base_libdir}", "${libdir}")}
			ln -sf ${relpath}/${realsofile} ${D}${libdir}/libpcre.so
			ln -sf ${relpath}/${realsofile} ${D}${libdir}/libpcre.so.1
		fi
	fi
}

FILES_${PN} += "${base_libdir}/libpcre.so.*"
