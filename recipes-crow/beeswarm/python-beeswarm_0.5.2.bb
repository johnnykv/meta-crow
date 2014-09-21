DESCRIPTION = "beeswarm"
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file:///tmp/blah;md5=0d599f0ec05c3bda8c3b8a68c32a1b47"

SRC_URI = "http://aaapypi.python.org/packages/source/B/Beeswarm/Beeswarm-${PV}.tar.gz"

SRC_URI[md5sum] = "Aed3b6689a08d54cce7bb41b159bd4fbf"

S = "${WORKDIR}/beeswarm-${PV}"

inherit setuptools

BBCLASSEXTEND = "native"

do_install_append() {
	rm -rf ${D}${datadir}/share
}
