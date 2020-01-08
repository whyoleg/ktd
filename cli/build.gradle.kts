plugins {
    use(Plugins.cliModule)
}

kotlin {
    default()
    target {
        dependenciesMain {
            implementation(Dependencies.kotlin.stdlib)
            implementation(Dependencies.kotlinx.cli.jvm)
            implementation(Dependencies.githubApi)
            implementation(Dependencies.kotlinShell)
            implementation(Dependencies.dotenv)
        }
    }
}
//shadow
