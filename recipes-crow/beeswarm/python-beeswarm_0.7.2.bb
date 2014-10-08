DESCRIPTION = "beeswarm"
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://README.rst;md5=96a464b158cc90d1392b88a339b5d459"

SRC_URI = "http://pypi.python.org/packages/source/B/Beeswarm/Beeswarm-${PV}.tar.gz"

SRC_URI[md5sum] = "9622afe401abb27c272195e05fa0cf38"
SRC_URI[sha256sum] = "b0a2d6ce11be7e775f72b5b3ab8a770fe11a646bcbe25853e55221d869f63a61"

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
                  python-smtpd \
                  python-telnetsrv \
                  python-sqlalchemy \
                  python-lxml \
                  python-flask \
                  python-mock \
                  python-netifaces \
                  python-flask-login \
                  python-flask-wtf \
                  python-misc \
                  python-mailbox \
                  python-werkzeug "

do_install_append() {
	rm -rf ${D}${datadir}/share
}
