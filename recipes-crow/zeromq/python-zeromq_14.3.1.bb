DESCRIPTION = "Python bindings for ZeroMq"
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING.BSD;md5=11c65680f637c3df7f58bbc8d133e96e"

SRC_URI = "https://pypi.python.org/packages/source/p/pyzmq/pyzmq-${PV}.tar.gz"

SRC_URI[md5sum] = "7196b4a6fbf98022f17ffa924be3d68d"

S = "${WORKDIR}/pyzmq-${PV}"

# /home/jkv/poky/testbuild/tmp/sysroots/qemuarm/usr/

DEPENDS = " python-core \
            python-ctypes \
            python-datetime \ 
            python-fcntl \
            python-logging \
            python-math \
            python-threading \
            python-io \
            python-codecs \
            python-shell \
            python-netserver \
            python-multiprocessing \
            util-linux \
            zeromq "

RDEPENDS_${PN} = " python-core \
            python-ctypes \
            python-datetime \
            python-fcntl \
            python-logging \
            python-math \
            python-threading \
            python-io \
            python-codecs \
            python-netserver \
            python-shell \
            python-multiprocessing \
            python-ecdsa \
            util-linux \
            zeromq "

FILES_${PN}-dbg += "${libdir}/python2.7/site-packages/zmq/backend/cython/.debug"

inherit setuptools

do_configure() {

# will force pyzmq to compile and embed zmq itself
export ZMQ_DIR=/blahblah

}

do_install_append() {
        rm -rf ${D}${datadir}/share
}
