DESCRIPTION = "User session management for Flask"
HOMEPAGE = "https://pypi.python.org/pypi/Flask-Login/"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8aa87a1cd9fa41d969ad32cfdac2c596"

PR = "r0"
SRCNAME = "Flask-Login"

SRC_URI = "https://pypi.python.org/packages/source/F/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
SRC_URI[sha256sum] = "83d5f10e5c4f214feed6cc41c212db63a58a15ac32e56df81591bfa0a5cee3e5"
SRC_URI[md5sum] = "c0a7eaf28623f0aeac4929dc05a7a064"

ENDS_${PN} += "python-core python-flask"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
