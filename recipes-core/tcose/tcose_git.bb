DESCRIPTION = "A C implementation of the Constrained Application Protocol"
HOMEPAGE = "https://github.com/laurencelundblade/t_cose"

LICENSE = "CLOSED"

SRC_URI = "\
    git://github.com/laurencelundblade/t_cose.git;protocol=https;branch=master \
    file://0001-Makefile-Allow-to-overite-the-compiler.patch \
"

SRCREV = "87583c35c38593568e6f2bafe8b6634f80bdbeed"

S = "${WORKDIR}/git"
TARGET_CC_ARCH += "${LDFLAGS}"

DEPENDS = 'qcbor mbedtls'

do_compile () {
    oe_runmake -f Makefile.psa
}

do_install () {
    oe_runmake -f Makefile.psa install install_so DESTDIR=${D} PREFIX=${exec_prefix}
}

RDEPENDS_${PN} += "qcbor"
