#
# Copyright (C) 2014 Crow Solutions 
#

SUMMARY = "Adding Dolos to full-cmdline"
DESCRIPTION = ""
PR = "r0"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-dolos-beeswarm \
    "

RDEPENDS_packagegroup-dolos-beeswarm = "\
packagegroup-core-full-cmdline \
python-beeswarm \
"
