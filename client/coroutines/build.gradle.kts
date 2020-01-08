plugins {
    use(Plugins.mppModule)
}

android { default() }

kotlin {
    configureMultiplatform()
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        api(Dependencies.kotlinx.coroutines.core)
        api(Dependencies.kotlinx.atomicfu.runtime)
    }
    metadata {
        dependenciesMain {
            api(Dependencies.kotlinx.immutableCollections.metadata)
            api(ProjectModules.Client.raw)
            compileOnly(ProjectModules.Api.stub)
        }
    }
}
