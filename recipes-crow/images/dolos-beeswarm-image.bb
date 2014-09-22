DESCRIPTION = "Dolos Beeswarm image"

IMAGE_FEATURES += "splash ssh-server-openssh"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-dolos-beeswarm \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image
