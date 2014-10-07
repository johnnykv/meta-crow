SUMMARY = "Various utility functions for SQLAlchemy."
HOMEPAGE = "https://pypi.python.org/pypi/SQLAlchemy-Utils/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=80e5ba73891255687dff3bee2b4cbb16"

SRCNAME = "mock"

SRC_URI = "https://pypi.python.org/packages/source/s/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "36a000c19f9beaa25cecc8b5306f1929"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} += " \
    python-pytest \
    python-pygments \
    python-jinja2 \
    python-docutils \
    python-flexmock \
    python-psycopg2 \
    python-pytz \
    python-dateutil \
    python-mysql \
    python-anyjson \
    python-babel \
    python-arrow \
    python-intervals \
    python-passlib \
    python-colour \
    python-ipaddr \
    python-dateutil \
    python-furl"