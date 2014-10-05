SUMMARY = "Python 2 and 3 compatibility utilities"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=530f34047c21ad45b3199946dd90bea5"

RDEPENDS_${PN} += "python-mime python-pprint python-re"

SRC_URI = "http://pypi.python.org/packages/source/s/six/six-${PV}.tar.gz"
SRC_URI[sha256sum] = "047bbbba41bac37c444c75ddfdf0573dd6e2f1fbd824e6247bb26fa7d8fa3830"

S = "${WORKDIR}/six-${PV}"

inherit setuptools



