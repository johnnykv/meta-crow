SUMMARY = "Requests is an Apache2 Licensed HTTP library, written in Python, for human beings."
DESCRIPTION = "Requests is an Apache2 Licensed HTTP library, written in Python, for human beings."
HOMEPAGE = "http://docs.python-requests.org/en/latest/"
SECTION = "devel/python"
LICENSE = "APACHE2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c7869e52c8275537186de35e3cd5f9ec"

# TODO: Figure out runtime dependes..
RDEPENDS_${PN} += "python-mime \
                   python-pprint \
                   python-email \
                   python-zlib"

SRC_URI = "http://pypi.python.org/packages/source/r/requests/requests-${PV}.tar.gz"
SRC_URI[md5sum] = "931461f761c70708c46ea65b7889da58"
SRC_URI[sha256sum] = "35d890b0aaa6e09ec40d49361d823b998ced86cc7673a9ce70bbc4f986e13ad8"

S = "${WORKDIR}/requests-${PV}"

inherit setuptools



