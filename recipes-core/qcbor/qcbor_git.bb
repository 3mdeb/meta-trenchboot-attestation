DESCRIPTION = "A C implementation of the Constrained Application Protocol"
HOMEPAGE = "https://github.com/obgm/libcoap"

LICENSE = "CLOSED"

SRC_URI = "git://github.com/laurencelundblade/QCBOR.git;protocol=https;branch=master"
SRC_URI += "file://0001-Makefile-Use-CC-as-a-compiler.patch"
SRC_URI += "file://0001-Makefile-link-math-library.patch"
SRC_URI += "file://0001-Makefile-Allow-specifying-lib-directory.patch"

SRCREV = "7278700c32ec763b56efa1f5995c120c8af0140e"

S = "${WORKDIR}/git"
TARGET_CC_ARCH += "${LDFLAGS}"

do_install_genericx86-64 () {
    oe_runmake install install_so DESTDIR=${D} PREFIX=${exec_prefix}
    # t_cose requires the library in the lib64 directory
    install -d ${D}${exec_prefix}/lib64
    cp ${D}${libdir}/libqcbor.so ${D}${exec_prefix}/lib64
}

do_install_pcengines-apux () {
    oe_runmake install install_so DESTDIR=${D} PREFIX=${exec_prefix} LIB_PREFIX=${exec_prefix}/lib64
    install -d ${D}${exec_prefix}/lib
    cp ${D}${libdir}/libqcbor.so ${D}${exec_prefix}/lib
}

FILES_${PN} = "${exec_prefix}"

RDEPENDS_${PN} = "glibc-dev"

INSANE_SKIP = "dev-deps"
