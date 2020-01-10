plugins {
    use(Plugins.cliModule)
}

kotlin {
    default()
    target {
        dependenciesMain {
            implementation(Dependencies.kotlin.stdlib)
            implementation(Dependencies.kotlinx.cli.jvm)
            implementation(Dependencies.kotlinx.serialization.runtime)
            implementation(Dependencies.kotlinx.serialization.configParser)
            implementation(Dependencies.githubApi)
            implementation(Dependencies.kotlinShell)
        }
    }
}
shadow()
