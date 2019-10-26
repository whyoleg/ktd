plugins {
    `java-library`
}

configuredKamp {
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
                +Dependencies.immutableCollections
            }
        }
    }
    publishing {
        bintray(publication) {
            repo = "ktd"
        }
    }
}

//TODO add this to kamp, them remove
tasks {
    jar {
        from("src/main/libs") {
            include("**/**/libtdjni.so")
        }
    }
}
