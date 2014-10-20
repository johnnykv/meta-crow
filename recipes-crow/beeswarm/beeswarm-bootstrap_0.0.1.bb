SUMMARY = "Beeswarm localhost bootstrapper"

SRC_URI = "file://beeswarm-bootstrap-init"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

RDEPENDS_${PN} = "python-core python-beeswarm"

inherit update-rc.d
INITSCRIPT_NAME = "beeswarm-bootstrap"

do_install_append () {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/beeswarm-bootstrap-init ${D}${sysconfdir}/init.d/beeswarm-bootstrap

}

