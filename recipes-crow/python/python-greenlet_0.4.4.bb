SUMMARY = "Lightweight in-process concurrent programming"
DESCRIPTION = "The greenlet package is a spin-off of Stackless, a version of CPython that supports micro-threads called \
tasklets"
HOMEPAGE = "http://greenlet.readthedocs.org/en/latest/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=03143d7a1a9f5d8a0fee825f24ca9c36"

RDEPENDS_${PN} += ""

SRC_URI = "http://pypi.python.org/packages/source/g/greenlet/greenlet-${PV}.zip"
SRC_URI[md5sum] = "1be0822a0b2467d0d08cf5d0224d965b"
SRC_URI[sha256sum] = "935a76b7ad3c41846af26e136e2fd8ec763794cbc5b5fbc4b7b09d9a8de1d056"

S = "${WORKDIR}/greenlet-${PV}"

inherit setuptools



