plugins {
    use(Plugins.mppModule)
}

configureMultiplatform()
configurePublishing("client-raw")

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
    }
    metadata {
        dependenciesMain {
            api(ProjectModules.core)
        }
    }
}
