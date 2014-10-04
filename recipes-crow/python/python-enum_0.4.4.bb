SUMMARY = "Python enum"
DESCRIPTION = "Robust enumerated type support in Python."
HOMEPAGE = "https://pypi.python.org/pypi/enum/"
SECTION = "devel/python"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE.GPL;md5=4325afd396febcb659c36b49533135d4"

RDEPENDS_${PN} += "python-core"

SRC_URI = "http://pypi.python.org/packages/source/e/enum/enum-${PV}.tar.gz"
SRC_URI[md5sum] = "ce75c7c3c86741175a84456cc5bd531e"
SRC_URI[sha256sum] = "9bdfacf543baf2350df7613eb37f598a802f346985ca0dc1548be6494140fdff"

S = "${WORKDIR}/enum-${PV}"

inherit setuptools



