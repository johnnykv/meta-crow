DESCRIPTION = "SSH2 protocol library"
HOMEPAGE = "https://github.com/paramiko/paramiko/"
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fd0120fc2e9f841c73ac707a30389af5"

PR = "r0"
SRCNAME = "paramiko"

SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "48c274c3f9b1282932567b21f6acf3b5"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-pycrypto"