SUMMARY = "Beeswarm localhost bootstrapper"

SRC_URI = "file://beeswarm-bootstrap-init \
           file://beeswarm-bootstrap-server \
           file://beeswarm-bootstrap-drone \
           file://beeswarm-dolos-init \ 
           file://dolos.cfg_original \
           file://monit-beeswarm-server \
           file://monit-beeswarm-drone \
           file://monit-beeswarm-general \
           file://ossec_server_files/local_decoder.xml \
           file://ossec_server_files/dolos_rules.xml"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"
PR="2"
RDEPENDS_${PN} += "monit ntpdate ${PN}-drone ${PN}-server ${PN}-dolos python-core python-beeswarm"
PACKAGES = "${PN} ${PN}-server ${PN}-drone ${PN}-dolos"

INITSCRIPT_PACKAGES                 = "${PN}-server ${PN}-drone ${PN}-dolos ${PN}"
INITSCRIPT_NAME_${PN}               = "beeswarm-bootstrap-init"
INITSCRIPT_PARAMS_${PN}             = "defaults 10 20"

INITSCRIPT_NAME_${PN}-server   = "beeswarm-bootstrap-server"
INITSCRIPT_PARAMS_${PN}-server = "defaults 20 10"

INITSCRIPT_NAME_${PN}-drone   = "beeswarm-bootstrap-drone"
INITSCRIPT_PARAMS_${PN}-drone = "defaults 25 9"

INITSCRIPT_NAME_${PN}-dolos   = "beeswarm-dolos-init"
INITSCRIPT_PARAMS_${PN}-dolos = "defaults 26 9"

inherit update-rc.d

FILES_${PN} = "${sysconfdir}/init.d/beeswarm-bootstrap-init ${sysconfdir}/dolos_config/ossec_rules/local_decoder.xml ${sysconfdir}/dolos_config/ossec_rules/dolos_rules.xml"
FILES_${PN}-server = "${sysconfdir}/init.d/beeswarm-bootstrap-server ${sysconfdir}/monit.d/monit-beeswarm-server"
FILES_${PN}-drone = "${sysconfdir}/init.d/beeswarm-bootstrap-drone CONFFILES_${PN}-drone += ${sysconfdir}/monit.d/monit-beeswarm-drone"
FILES_${PN}-dolos = "${sysconfdir}/init.d/beeswarm-dolos-init ${sysconfdir}/dolos_config/dolos.cfg_original ${sysconfdir}/monit.d/monit-beeswarm-general"

do_install_append () {
	install -d ${D}${sysconfdir}/init.d
        install -m 0755 -d ${D}${sysconfdir}/dolos_config/
        install -m 0755 -d ${D}${sysconfdir}/dolos_config/ossec_rules
        install -m 0755 ${WORKDIR}/ossec_server_files/dolos_rules.xml ${D}${sysconfdir}/dolos_config/ossec_rules/dolos_rules.xml
        install -m 0755 ${WORKDIR}/ossec_server_files/local_decoder.xml ${D}${sysconfdir}/dolos_config/ossec_rules/local_decoder.xml
        install -m 0755 ${WORKDIR}/dolos.cfg_original ${D}${sysconfdir}/dolos_config/dolos.cfg_original
	install -m 0755 ${WORKDIR}/beeswarm-bootstrap-init ${D}${sysconfdir}/init.d/beeswarm-bootstrap-init
        install -m 0755 ${WORKDIR}/beeswarm-bootstrap-server ${D}${sysconfdir}/init.d/beeswarm-bootstrap-server
        install -m 0755 ${WORKDIR}/beeswarm-bootstrap-drone ${D}${sysconfdir}/init.d/beeswarm-bootstrap-drone
        install -m 0755 ${WORKDIR}/beeswarm-dolos-init ${D}${sysconfdir}/init.d/beeswarm-dolos-init
        install -m 700 -d ${D}${sysconfdir}/monit.d/
        install -m 0755 ${WORKDIR}/monit-beeswarm-drone ${D}${sysconfdir}/monit.d/monit-beeswarm-drone
        install -m 0755 ${WORKDIR}/monit-beeswarm-server ${D}${sysconfdir}/monit.d/monit-beeswarm-server 
        install -m 0755 ${WORKDIR}/monit-beeswarm-general ${D}${sysconfdir}/monit.d/monit-beeswarm-general
}

