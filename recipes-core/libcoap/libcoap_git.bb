DESCRIPTION = "A C implementation of the Constrained Application Protocol"
HOMEPAGE = "https://github.com/obgm/libcoap"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=62a1cb19feee5d5dc7cad8cdbe85a8c1"

SRC_URI = "git://github.com/obgm/libcoap.git;protocol=https;branch=develop;name=libcoap"
SRC_URI += "gitsm://github.com/eclipse/tinydtls.git;protocol=https;branch=develop;destsuffix=git/ext/tinydtls;name=tinydtls"

SRCREV_libcoap = "eb7656850f1cf4282e3ff7ab880f50d5cdfab685"
SRCREV_tinydtls = "706888256c3e03d9fcf1ec37bb1dd6499213be3c"

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

do_configure:prepend() {
    ./autogen.sh
}

do_install () {
    oe_runmake install DESTDIR=${D}
}
