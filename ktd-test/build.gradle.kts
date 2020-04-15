plugins {
    use(Plugins.mppModule + Plugins.atomicfuModule)
}

configureMultiplatform()

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        compileOnly(Dependencies.atomicfuMpp)
    }
    metadata {
        dependenciesMain {
            api(ProjectModules.core)
        }
    }
}
