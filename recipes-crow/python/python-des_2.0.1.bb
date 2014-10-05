SUMMARY = "Pure python implementation of DES and TRIPLE DES encryption algorithm"
HOMEPAGE = "http://twhiteman.netfirms.com/des.html/"
SECTION = "devel/python"
LICENSE = "Public Domain"
LIC_FILES_CHKSUM = "file://README.txt;md5=96b9ebbcf1d9bc43eb36e259e83fbbe8"

RDEPENDS_${PN} += "python-core"

SRC_URI = "http://twhiteman.netfirms.com/pyDES/pyDes-${PV}.zip"
SRC_URI[md5sum] = "90f06a24a1ee73fb0e235571d51c287a"
SRC_URI[sha256sum] = "9cc6e509f627ef1c2d318730d22f1a33f23b41e1ec223b55a6420f2861266d76"

S = "${WORKDIR}/pyDes-${PV}"

inherit setuptools



