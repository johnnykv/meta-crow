SUMMARY = "Filesystem abstraction layer"
DESCRIPTION = "PyFilesystem is an abstraction layer for filesystems."
HOMEPAGE = "http://docs.pyfilesystem.org/en/latest/"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=29607833435a8c40c0c7622e4e8f99fa"

RDEPENDS_${PN} += "python-mime python-pprint python-re"

SRC_URI = "http://pypi.python.org/packages/source/f/fs/fs-${PV}.tar.gz"
SRC_URI[md5sum] = "0636988bee49f06db2b9bb1f67396ca5"
SRC_URI[sha256sum] = "39426d4c03e954ff4be2418606ae3dc3e8d1f95d2a569bb780dd6e2bac278e90"

S = "${WORKDIR}/fs-${PV}"

inherit setuptools



