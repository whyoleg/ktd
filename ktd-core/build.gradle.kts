plugins {
    use(Plugins.mppModule + Plugins.serializationModule + Plugins.atomicfuModule)
}

configureMultiplatform()

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        api(Dependencies.kotlinx.serialization.runtime)
        compileOnly(Dependencies.kotlinx.atomicfu.runtime)
    }
    dependenciesTest {
        implementation(Dependencies.kotlin.test)
        implementation(Dependencies.kotlin.annotations)
        runtimeOnly(Dependencies.kotlinx.atomicfu.runtime)
    }

    metadata {
        dependenciesMain {
            api(ProjectModules.json)
        }
    }
}
