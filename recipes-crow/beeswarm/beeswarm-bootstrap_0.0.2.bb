SUMMARY = "Beeswarm localhost bootstrapper"

SRC_URI = "file://beeswarm-bootstrap-init file://beeswarm-bootstrap-server"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

RDEPENDS_${PN} += "python-core python-beeswarm"

RDEPENDS_${PN}-server = "${PN}"

PACKAGES = "${PN}-server"

INITSCRIPT_PACKAGES                 = "${PN} ${PN}-server"
INITSCRIPT_NAME_${PN}               = "beeswarm-bootstrap-init"
INITSCRIPT_PARAMS_${PN}             = "defaults 10 20"

INITSCRIPT_NAME_${PN}-server   = "beeswarm-bootstrap-server"
INITSCRIPT_PARAMS_${PN}-server = "defaults 20 10"

inherit update-rc.d

FILES_${PN} = "${sysconfdir}/init.d/beeswarm-bootstrap-init"
FILES_${PN}-server = "${sysconfdir}/init.d/beeswarm-bootstrap-server"

do_install_append () {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/beeswarm-bootstrap-init ${D}${sysconfdir}/init.d/beeswarm-bootstrap-init
        install -m 0755 ${WORKDIR}/beeswarm-bootstrap-server ${D}${sysconfdir}/init.d/beeswarm-bootstrap-server
}

