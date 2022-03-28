DESCRIPTION = "A C implementation of the Constrained Application Protocol"
HOMEPAGE = "https://github.com/laurencelundblade/t_cose"

LICENSE = "CLOSED"

SRC_URI = "\
    git://github.com/laurencelundblade/t_cose.git;protocol=https;branch=master \
    file://0001-Makefile-Allow-to-overite-the-compiler.patch \
    file://0001-Makefile-Allow-to-overwrite-include-path.patch \
"

SRCREV = "b56e2b952492fc1d1056d3a8f1db1ad161acb0aa"

S = "${WORKDIR}/git"
TARGET_CC_ARCH += "${LDFLAGS}"

DEPENDS = 'qcbor mbedtls'

do_compile () {
    oe_runmake -f Makefile.psa QCBOR_INC= CRYPTO_INC=
}

do_install () {
    oe_runmake -f Makefile.psa install install_so DESTDIR=${D} PREFIX=${exec_prefix}
}

INSANE_SKIP = "dev-so staticdev"

RDEPENDS_${PN} += "qcbor"

FILES_${PN} += "${exec_prefix}/lib"
