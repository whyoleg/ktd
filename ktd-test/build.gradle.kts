plugins {
    use(Plugins.mppModule + Plugins.atomicfuModule)
}

configureMultiplatform(
    publishable = false
)

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        compileOnly(Dependencies.kotlinx.atomicfu.runtime)
    }
    metadata {
        dependenciesMain {
            api(ProjectModules.core)
        }
    }
}
