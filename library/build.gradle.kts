plugins {
    `java-library`
}

kampJvm {
    with(Plugins) {
        plugins(atomicfu, mavenPublish)
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