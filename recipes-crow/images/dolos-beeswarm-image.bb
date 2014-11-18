DESCRIPTION = "Dolos Beeswarm image"
PR = "r2"

IMAGE_FEATURES += "read-only-rootfs"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-dolos-beeswarm \
    beeswarm-bootstrap \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "
# Note: dollar signs are escaped in the hash!
EXTRA_USERS_PARAMS = "usermod -p '\$6\$5Spfs2RDwz//QSC\$p5dgjKiVlUVUK213Hx9QQ22eKl0Sn1w1XuarkW81Cnj5LxZItqsnfRq.1eZz72zyUUYFnYkeZfAGllK2OffBS.' root;"

inherit core-image extrausers
