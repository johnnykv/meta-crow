DESCRIPTION = "Open Source Host-based Intrusion Detection System"
HOMEPAGE = "http://www.ossec.net/"
LICENSE = "LGPLv3+"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=d5311495d952062e0e4fbba39cbf3de1"

SRC_URI = "http://www.ossec.net/files/ossec-hids-${PV}.tar.gz"

SRC_URI[md5sum] = "0d7fd090a120b378bd44a18319085d88"

S = "${WORKDIR}/ossec-${PV}/src"

EXTRA_OECONF += "--host arm-poky-linux-gnueabi --build x86_64-linux agent"

inherit autotools gettext

