SUMMARY = "ECDSA cryptographic signature library "
HOMEPAGE = "https://pypi.python.org/pypi/ecdsa"
SECTION = "devel/python"
LICENSE = "None"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=66ffc5e30f76cbb5358fe54b645e5a1d"

RDEPENDS_${PN} += "python-core python-tests python-time python-crypt python-unittest \
                   python-subprocess"

SRC_URI = "http://pypi.python.org/packages/source/e/ecdsa/ecdsa-${PV}.tar.gz"
SRC_URI[md5sum] = "8ef586fe4dbb156697d756900cb41d7c"
SRC_URI[sha256sum] = "8e3b6c193f91dc94b2f3b0261e3eabbdc604f78ff99fdad324a56fdd0b5e958c"

S = "${WORKDIR}/ecdsa-${PV}"

inherit setuptools



