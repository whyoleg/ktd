plugins {
    `java-library`
    `maven-publish`
}

kampJvmCommon {
    with(Plugins) {
        plugins(atomicfu)
    }
    source {
        main {
            implementation {
                +Dependencies.kotlin.stdlib
                +Dependencies.kotlinx.atomicfu
                +Dependencies.logging.logging
                +Dependencies.coroutines.core
                +Dependencies.tdlib
            }
        }
    }
    publishing {
        bintray(publication) {
            repo = "ktd"
        }
    }
}

tasks {
    jar {
        from("src/main/libs") {
            include("**/**/libtdjni.so")
        }
    }
}