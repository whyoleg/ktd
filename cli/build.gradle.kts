repositories {
    //TODO needed by kotlin shell
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
}

configure("cli") {
    packagers {
        jar {
            useVersion = false
        }
    }
    source {
        main {
            implementation {
                +Dependencies.kotlin.stdlib
                +Dependencies.githubApi
                +Dependencies.kotlinShell
                +Dependencies.cli
                +Dependencies.dotenv
            }
        }
    }
}