#!/bin/bash
#CONFIG_FILE="/media/card"
CONFIG_FILE="dolos.cfg_original"

# TODO: Loop this..
OSSEC_SERVER=$(awk -F"=" '/^OSSEC_SERVER/{gsub(/ /, "", $0);print $2}' $CONFIG_FILE)
AGENT_KEY=$(awk -F"=" '/^AGENT_KEY/{gsub(/ /, "", $0);print $2}' $CONFIG_FILE)
IP_MODE=$(awk -F"=" '/^IP_MODE/{gsub(/ /, "", $0);print $2}' $CONFIG_FILE)
IP_ADDRESS=$(awk -F"=" '/^IP_ADDRESS/{gsub(/ /, "", $0);print $2}' $CONFIG_FILE)
IP_BROADCAST=$(awk -F"=" '/^IP_BROADCAST/{gsub(/ /, "", $0);print $2}' $CONFIG_FILE)
IP_NETMASK=$(awk -F"=" '/^IP_NETMASK/{gsub(/ /, "", $0);print $2}' $CONFIG_FILE)


# TODO: Copy CONFIG_FILE.ORIGINAL to sdcard if not there
# TODO: put OSSEC_SERVER in <client> config in OSSEC config file
# TODO: base64 decode AGENT_KEY and put in client.keys
# TODO: Setup IP mode

AGENT_CONF="
<ossec_config>\n
  <client>\n
    <server-ip>$OSSEC_SERVER</server-ip>\n
  </client>\n
  <localfile>\n
    <log_format>syslog</log_format>\n
    <location>/var/log/syslog</location>\n
  </localfile>\n
</ossec_config>\n
"
echo $AGENT_CONF
