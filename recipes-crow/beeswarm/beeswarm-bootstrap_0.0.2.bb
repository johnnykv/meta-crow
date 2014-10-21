SUMMARY = "Beeswarm localhost bootstrapper"

SRC_URI = "file://beeswarm-bootstrap-init file://beeswarm-bootstrap-server file://beeswarm-bootstrap-drone"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

RDEPENDS_${PN} += "${PN}-drone ${PN}-server python-core python-beeswarm"
PACKAGES = "${PN} ${PN}-server ${PN}-drone"

INITSCRIPT_PACKAGES                 = "${PN}-server ${PN}-drone ${PN}"
INITSCRIPT_NAME_${PN}               = "beeswarm-bootstrap-init"
INITSCRIPT_PARAMS_${PN}             = "defaults 10 20"

INITSCRIPT_NAME_${PN}-server   = "beeswarm-bootstrap-server"
INITSCRIPT_PARAMS_${PN}-server = "defaults 20 10"

INITSCRIPT_NAME_${PN}-drone   = "beeswarm-bootstrap-drone"
INITSCRIPT_PARAMS_${PN}-drone = "defaults 25 9"

inherit update-rc.d

FILES_${PN} = "${sysconfdir}/init.d/beeswarm-bootstrap-init"
FILES_${PN}-server = "${sysconfdir}/init.d/beeswarm-bootstrap-server"
FILES_${PN}-drone = "${sysconfdir}/init.d/beeswarm-bootstrap-drone"

do_install_append () {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/beeswarm-bootstrap-init ${D}${sysconfdir}/init.d/beeswarm-bootstrap-init
        install -m 0755 ${WORKDIR}/beeswarm-bootstrap-server ${D}${sysconfdir}/init.d/beeswarm-bootstrap-server
        install -m 0755 ${WORKDIR}/beeswarm-bootstrap-drone ${D}${sysconfdir}/init.d/beeswarm-bootstrap-drone
}

