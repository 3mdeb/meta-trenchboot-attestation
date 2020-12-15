DESCRIPTION = "A C implementation of the Constrained Application Protocol"
HOMEPAGE = "https://github.com/obgm/libcoap"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=62a1cb19feee5d5dc7cad8cdbe85a8c1"

SRC_URI = "git://github.com/obgm/libcoap.git;protocol=https;branch=develop;name=libcoap"
SRC_URI += "gitsm://github.com/eclipse/tinydtls.git;protocol=https;branch=develop;destsuffix=git/ext/tinydtls;name=tinydtls"

SRCREV_libcoap = "f29f053d53c3dd16394b3a3d8ec604f3ffb277bf"
SRCREV_tinydtls = "290c48d262b6859443bd4b04926146bda3293c98"

inherit autotools pkgconfig bash-completion autotools-brokensep

DEPENDS += "binutils gnu-efi util-linux pkgconfig"

EXTRA_OECONF += "\
    --disable-tests \
    --disable-documentation \
    --disable-manpages \
    --disable-dtls \
    --disable-shared \
    --enable-fast-install \
"

S = "${WORKDIR}/git"
TARGET_CC_ARCH += "${LDFLAGS}"

do_configure_prepend() {
    ./autogen.sh
}

do_install () {
    oe_runmake install DESTDIR=${D}
}
