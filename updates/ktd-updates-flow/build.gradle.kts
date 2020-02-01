plugins {
    use(Plugins.mppModule)
}

configureMultiplatform()

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        api(Dependencies.kotlinx.coroutines.core)
        api(Dependencies.kotlinx.immutableCollections.metadata)
    }
    metadata {
        dependenciesMain {
            api(ProjectModules.client_api)
        }
    }
}
