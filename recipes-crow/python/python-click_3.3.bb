DESCRIPTION = "A simple wrapper around optparse for powerful command line utilities."
HOMEPAGE = "https://pypi.python.org/pypi/click/"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=09e8b7869f94ba9e9a7b260d53c65dab"

PR = "r0"
SRCNAME = "Flask"

SRC_URI = "https://pypi.python.org/packages/source/c/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "40edaba4d216915a8326c5b2cb52781d"

RDEPENDS_${PN} += "python-core"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools