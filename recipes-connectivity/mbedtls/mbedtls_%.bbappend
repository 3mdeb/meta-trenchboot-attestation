FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

S = "${WORKDIR}/git"
SRCREV = "523f0554b6cdc7ace5d360885c3f5bbcc73ec0e8"
SRC_URI = "git://github.com/ARMmbed/mbedtls.git;protocol=https;branch=development \
           file://fix-incorrect-EOF-check-in-ssl_context_info.patch \
"

BBCLASSEXTEND = "native nativesdk"
