DESCRIPTION = "Powerful and Pythonic XML processing library combining libxml2/libxslt with the ElementTree API."
HOMEPAGE = "http://lxml.de/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSES.txt;md5=f9f1dc24f720c143c2240df41fe5073b"

PR = "r3"

SRCNAME = "lxml"
SRC_URI = "http://pypi.python.org/packages/source/l/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "88c75f4c73fc8f59c9ebb17495044f2f"
SRC_URI[sha256sum] = "6ad6949dc7eea744a30fba77a968dd5910f545220e58bcc813b9df5c793e318a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

EXTRA_OECONF += "--host arm-poky-linux-gnueabi --build x86_64-linux"

DEPENDS = "libxml2 libxslt"

inherit setuptools

# DEPENDS_default: python-pip

# RDEPENDS_default:
RDEPENDS_${PN} += " \
        python-beautifulsoup4 \
        python-cssselect \
        libxml2 \
        libxslt \
        python-compression "
