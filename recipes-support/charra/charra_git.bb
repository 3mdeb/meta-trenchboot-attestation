DESCRIPTION = "Challenge-Response based Remote Attestation with TPM 2.0"
HOMEPAGE = "https://github.com/Fraunhofer-SIT/charra"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE.md;md5=5aeab7914c62fb03925841d8fd65bced"

SRC_URI = "git://github.com/3mdeb/charra.git;protocol=https;branch=fix_quote;"

SRCREV = "c307ce609eb3bd652483b58b4a9c322c28bcbda5"

S = "${WORKDIR}/git"
TARGET_CC_ARCH += "${LDFLAGS}"

EXTRA_OEMAKE = "LIBINCLUDE=-B/usr/lib/gold-ld"

do_install(){
    install -d ${D}${sbindir}
    install -m 755 ${S}/bin/verifier ${D}${sbindir}/charra-verifier
    install -m 755 ${S}/bin/attester ${D}${sbindir}/charra-attester
}

DEPENDS = "\
    libcoap \
    libgcc \
    libtss2 \
    libtss2-mu \
    libtss2-tcti-device \
    libtss2-tcti-mssim \
    mbedtls \
    qcbor \
    tcose \
    tpm2-tools \
    tpm2-totp \
    tpm2-abrmd \
    tpm2-tss \
"

RDEPENDS_${PN} += "\
    bash \
    tpm2-tools \
    tpm2-totp \
    tpm2-abrmd \
    tpm2-tss \
    libtss2 \
    libtss2-mu \
    libtss2-tcti-device \
    libtss2-tcti-mssim \
    qcbor \
    tcose \
    libcoap \
    mbedtls \
"

FILES_${PN} += "\
    ${sbindir} \
"
