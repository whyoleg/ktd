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
}

tasks {
    jar {
        from("src/main/libs") {
            include("**/**/libtdjni.so")
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
        }
    }
}