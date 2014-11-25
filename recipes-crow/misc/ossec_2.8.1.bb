DESCRIPTION = "Open Source Host-based Intrusion Detection System"
HOMEPAGE = "http://www.ossec.net/"
LICENSE = "LGPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0d7fd090a120b378bd44a18319085d88"
PR="r4"
SRC_URI = "http://www.ossec.net/files/ossec-hids-${PV}.tar.gz \
file://ossec_2.8.1_absolute_path.diff \
file://ossec_2.8.1_tmp_defaultdit.diff \
file://ossec-volatile-init"

SRC_URI[md5sum] = "0d7fd090a120b378bd44a18319085d88"

S = "${WORKDIR}/ossec-hids-${PV}"

DEPENDS = "openssl-native"

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "-g 1300 ossec"
USERADD_PARAM_${PN} = "-u 1300 -g ossec -d /var/ossec -r -s /sbin/nologin ossec"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME_${PN} = "ossec-volatile-init"
INITSCRIPT_PARAMS_${PN} = "defaults 19 10"

FILES_${PN}-dbg =+ "/var/ossec/bin/.debug"
FILES_${PN} =+ " ${sysconfdir}/init.d/ossec-volatile-init"

inherit useradd update-rc.d

do_install() {
cd src
oe_runmake setagent 
oe_runmake all

mkdir ${D}/var
mkdir -m 0700 ${D}/var/ossec
DIR="${D}/var/ossec"

UNAME=`uname`;
NEW_GROUP="ossec"
NEW_USER="ossec"
subdirs="logs bin queue queue/ossec queue/alerts queue/syscheck queue/rids queue/diff var var/run etc etc/shared active-response active-response/bin agentless .ssh"

# Creating sub dirs
for i in ${subdirs}; do
    mkdir -m 700 ${DIR}/${i}
done

# Default for all directories
chmod -R 550 ${DIR}
chown -R root:${NEW_GROUP} ${DIR}

# To the ossec queue (default for agentd to read)
chown -R ${NEW_USER}:${NEW_GROUP} ${DIR}/queue/ossec
chmod -R 770 ${DIR}/queue/ossec

# For the logging user
chown -R ${NEW_USER}:${NEW_GROUP} ${DIR}/logs
chmod -R 750 ${DIR}/logs
chmod -R 775 ${DIR}/queue/rids
touch ${DIR}/logs/ossec.log
chown ${NEW_USER}:${NEW_GROUP} ${DIR}/logs/ossec.log
chmod 664 ${DIR}/logs/ossec.log

chown -R ${NEW_USER}:${NEW_GROUP} ${DIR}/queue/diff
chmod -R 750 ${DIR}/queue/diff
#chmod 740 ${DIR}/queue/diff/*

# For the etc dir
chmod 550 ${DIR}/etc
chown -R root:${NEW_GROUP} ${DIR}/etc

        # For the /etc/shared
cp -pr rootcheck/db/*.txt ${DIR}/etc/shared/

      cp -pr ../etc/internal_options.conf ${DIR}/etc/
#cp -pr ../etc/local_internal_options.conf ${DIR}/etc/
#cp -pr ../etc/client.keys ${DIR}/etc/
cp -pr agentlessd/scripts/* ${DIR}/agentless/

chown root:${NEW_GROUP} ${DIR}/etc/internal_options.conf
#chown root:${NEW_GROUP} ${DIR}/etc/local_internal_options.conf
#chown root:${NEW_GROUP} ${DIR}/etc/client.keys
chown root:${NEW_GROUP} ${DIR}/agentless/*
chown ${NEW_USER}:${NEW_GROUP} ${DIR}/.ssh
chown -R root:${NEW_GROUP} ${DIR}/etc/shared

chmod 550 ${DIR}/etc
chmod 440 ${DIR}/etc/internal_options.conf
#chmod 440 ${DIR}/etc/local_internal_options.conf
#chmod 440 ${DIR}/etc/client.keys > /dev/null
chmod -R 770 ${DIR}/etc/shared # ossec must be able to write to it
chmod 550 ${DIR}/agentless/*
chmod 700 ${DIR}/.ssh


# For the /var/run
chmod 770 ${DIR}/var/run
chown root:${NEW_GROUP} ${DIR}/var/run


# Moving the binary files
cp -pr client-agent/ossec-agentd ${DIR}/bin/
cp -pr os_auth/agent-auth ${DIR}/bin/
cp -pr logcollector/ossec-logcollector ${DIR}/bin/
cp -pr syscheckd/ossec-syscheckd ${DIR}/bin/
cp -pr os_execd/ossec-execd ${DIR}/bin/
cp -pr ./init/ossec-client.sh ${DIR}/bin/ossec-control
cp -pr addagent/manage_agents ${DIR}/bin/
cp -pr ../contrib/util.sh ${DIR}/bin/
cp -pr external/lua/src/ossec-lua ${DIR}/bin/
cp -pr external/lua/src/ossec-luac ${DIR}/bin/
chown root:${NEW_GROUP} ${DIR}/bin/util.sh
chmod +x ${DIR}/bin/util.sh

# Copying active response modules
sh ./init/fw-check.sh execute > /dev/null
cp -pr ../active-response/*.sh ${DIR}/active-response/bin/
cp -pr ../active-response/firewalls/*.sh ${DIR}/active-response/bin/
chmod 755 ${DIR}/active-response/bin/*
chown root:${NEW_GROUP} ${DIR}/active-response/bin/*

chown root:${NEW_GROUP} ${DIR}/bin/*
chmod 550 ${DIR}/bin/*



# TODO: Configure this..   
cp -pr ../etc/ossec-agent.conf ${DIR}/etc/ossec.conf

chown root:${NEW_GROUP} ${DIR}/etc/ossec.conf
chmod 440 ${DIR}/etc/ossec.conf

install -d ${D}${sysconfdir}/init.d
install -m 0755 ${WORKDIR}/ossec-volatile-init ${D}${sysconfdir}/init.d/ossec-volatile-init


}

BBCLASSEXTEND = "native"

