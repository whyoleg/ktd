plugins {
    use(Plugins.mppModule)
}

configureMultiplatform()

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
