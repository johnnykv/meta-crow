DESCRIPTION = "Simple integration of Flask and WTForms"
HOMEPAGE = "https://pypi.python.org/pypi/Flask-WTF/"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d1eb373eabc6d20a5c4f2a2214f42b71"

PR = "r0"
SRCNAME = "Flask-WTF"

SRC_URI = "https://pypi.python.org/packages/source/F/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "2932ac0e7e8df26f6efb6ee7e6cfb783"
SRC_URI[sha256sum] = "2926a265e6aa163a2102a8f058ad89acb9304665c476cea9687243bcc8f99b45"

ENDS_${PN} += "python-core python-flask"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
