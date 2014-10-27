DESCRIPTION = "Dolos Beeswarm image"
PR = "r2"

IMAGE_FEATURES += "read-only-rootfs"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-dolos-beeswarm \
    beeswarm-bootstrap \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image
