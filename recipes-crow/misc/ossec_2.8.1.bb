DESCRIPTION = "Open Source Host-based Intrusion Detection System"
HOMEPAGE = "http://www.ossec.net/"
LICENSE = "LGPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0d7fd090a120b378bd44a18319085d88"

SRC_URI = "http://www.ossec.net/files/ossec-hids-${PV}.tar.gz"

SRC_URI[md5sum] = "0d7fd090a120b378bd44a18319085d88"

S = "${WORKDIR}/ossec-hids-${PV}"

#EXTRA_OEMAKE += "agent"
#EXTRA_OEMAKE += "--host arm-poky-linux-gnueabi --build x86_64-linux agent"

do_install() {
        cd src
        mkdir ${D}/var
        mkdir ${D}/var/ossec
        echo "DIR=${D}/var/ossec" > LOCATION
	oe_runmake agent
}

BBCLASSEXTEND = "native"

