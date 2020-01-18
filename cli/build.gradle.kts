plugins {
    use(Plugins.cliModule)
}

version = properties["cliVersion"]!!

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
            implementation(Dependencies.ktor.client.cio)
        }
    }
}
shadow()
