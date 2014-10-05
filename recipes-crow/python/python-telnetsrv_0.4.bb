SUMMARY = "Telnet server using gevent or threading."
SECTION = "devel/python"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=e6a600fd5e1d9cbde2d983680233ad02"

RDEPENDS_${PN} += "python-core python-curses python-netserver python-threading python-paramiko"

SRC_URI = "http://pypi.python.org/packages/source/t/telnetsrv/telnetsrv-${PV}.tar.gz"
SRC_URI[md5sum] = "eb59ce5a765c4f9acb85f60342ae0be9"
SRC_URI[sha256sum] = "195fa7acdeba7bb46a1a320c0afd66e23b5d7ab8810393468a05936113d84799"

S = "${WORKDIR}/telnetsrv-${PV}"

inherit setuptools



