DESCRIPTION = "Python NTP lib"
SECTION = "devel/python"
LICENSE = "GNU v2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

PR = "r0"
SRCNAME = "ntplib"

SRC_URI = "https://pypi.python.org/packages/source/n/ntplib/ntplib-${PV}.tar.gz"

SRC_URI[md5sum] = "0f386dc00c0056ac4d77af0b4c21bb8e"
SRC_URI[sha256sum] = "14847bd4509b9212d6a03788590784abeff85c88021d8fd3b151da2f1ab8568d"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
