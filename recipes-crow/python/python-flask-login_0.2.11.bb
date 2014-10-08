DESCRIPTION = "User session management for Flask"
HOMEPAGE = "https://pypi.python.org/pypi/Flask-Login/"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=79aa8b7bc4f781210d6b5c06d6424cb0"

PR = "r0"
SRCNAME = "Flask-Login"

SRC_URI = "https://pypi.python.org/packages/source/F/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "c0a7eaf28623f0aeac4929dc05a7a064"

ENDS_${PN} += "python-core python-flask"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools