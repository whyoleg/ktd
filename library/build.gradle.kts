plugins {
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
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "dev.whyoleg"
            artifactId = "ktd"
            version = "0.1.0"

            from(components["java"])
            artifact(file("src/main/libs/libtdjni.so"))
        }
    }
}