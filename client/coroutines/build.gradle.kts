plugins {
    use(Plugins.mppModule + Plugins.atomicfuModule)
}

configureMultiplatform()

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        api(Dependencies.kotlinx.coroutines.core)
        api(Dependencies.kotlinx.immutableCollections.metadata)
        compileOnly(Dependencies.kotlinx.atomicfu.runtime)
    }
    metadata {
        dependenciesMain {
            api(ProjectModules.Client.raw)
            compileOnly(ProjectModules.Api.stub)
        }
    }
}
