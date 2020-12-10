DESCRIPTION = "A C implementation of the Constrained Application Protocol"
HOMEPAGE = "https://github.com/obgm/libcoap"

LICENSE = "CLOSED"

SRC_URI = "git://github.com/laurencelundblade/QCBOR.git;protocol=https;branch=master"
SRC_URI += "file://0001-Makefile-Use-CC-as-a-compiler.patch"

SRCREV = "c02e13eb6263381195290424c4cdffd440a0aa96"

S = "${WORKDIR}/git"
TARGET_CC_ARCH += "${LDFLAGS}"

do_install () {
    oe_runmake install install_so DESTDIR=${D} PREFIX=${exec_prefix}
    # t_cose requires the library in the lib64 directory
    install -d ${D}${exec_prefix}/lib64
    cp ${D}${libdir}/libqcbor.so ${D}${exec_prefix}/lib64
}

FILES_${PN} = "${exec_prefix}"
