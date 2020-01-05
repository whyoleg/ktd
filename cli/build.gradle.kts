import dev.whyoleg.kamp.modules.*

plugins {
    use(Plugins.cliModule)
}

kotlin {
    default()
    target {
        dependenciesMain {
            implementation(Dependencies.kotlin.stdlib)
            implementation(Dependencies.kotlinx.cli)
            implementation(Dependencies.githubApi)
            implementation(Dependencies.kotlinShell)
            implementation(Dependencies.dotenv)
        }
    }
}
//shadow
