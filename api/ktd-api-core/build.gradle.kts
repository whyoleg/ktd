plugins {
    use(Plugins.mppModule + Plugins.serializationModule)
}

configureMultiplatform()

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        api(Dependencies.kotlinx.serialization.runtime)
    }
    metadata {
        dependenciesMain {
            api(ProjectModules.core)
            api(ProjectModules.tdlib)
        }
    }
}
