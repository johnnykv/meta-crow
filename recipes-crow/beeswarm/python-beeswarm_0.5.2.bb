DESCRIPTION = "beeswarm"
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://README.rst;md5=96a464b158cc90d1392b88a339b5d459"

SRC_URI = "http://pypi.python.org/packages/source/B/Beeswarm/Beeswarm-${PV}.tar.gz"

SRC_URI[md5sum] = "ed3b6689a08d54cce7bb41b159bd4fbf"
SRC_URI[sha256sum] = "c73a0418ddb30039330b319a0c697b22016dc871096dae5e81feb028e373a08b"

S = "${WORKDIR}/Beeswarm-${PV}"

inherit setuptools

BBCLASSEXTEND = "native"

RDEPENDS_${PN} = "python-zeromq \
		  python-json \
                  python-crypt \
                  python-gevent \
                  python-fs \
                  python-email \
                  python-nose \
                  python-argparse \
                  python-requests \
                  python-enum \
                  python-unixadmin \
                  python-openssl \
                  python-crypto \
		  		  python-netifaces \
		  		  python-curses \
                  python-ntplib \
                  python-ecdsa \
                  python-cssselect \
                  python-nose \
                  python-paramiko \
                  python-des \
                  python-sendfile \
                  python-smtpd"

do_install_append() {
	rm -rf ${D}${datadir}/share
}
