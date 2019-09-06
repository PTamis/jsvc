SUMMARY = "Apache Commons Daemon"
DESCRIPTION = "Apache Commons Daemon is a set of utilities and Java support classes \
               for running Java applications as server processes. \
               Commonly known as 'daemon' processes in Unix terminology (hence the name), \
               on Windows they are called 'services'"
HOMEPAGE = "http://commons.apache.org/"
LICENSE  = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/commons-daemon-${PV}-native-src/LICENSE.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "https://archive.apache.org/dist/commons/daemon/source/commons-daemon-${PV}-native-src.tar.gz"
SRC_URI[md5sum] = "79fd2cf92342ec002e7fe12385b9be2a"
SRC_URI[sha256sum] = "13c8d9b27d38ae1ced1fb37743239035cd1add74a8ef20bfce38386fc0b4a243"

inherit autotools-brokensep
DEPENDS = "openjdk-8-native"

export JAVA_HOME = "${STAGING_LIBDIR_NATIVE}/jvm/openjdk-8-native"

S = "${WORKDIR}/commons-daemon-${PV}-native-src/unix"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/jsvc ${D}${bindir}
}
