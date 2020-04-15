plugins {
    use(Plugins.mppModule + Plugins.serializationModule + Plugins.atomicfuModule)
}

configureMultiplatform()
configurePublishing("core")

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        api(Dependencies.kotlinx.serialization.runtime)
        compileOnly(Dependencies.atomicfuMpp)
    }
    dependenciesTest {
        implementation(Dependencies.kotlin.test)
        implementation(Dependencies.kotlin.annotations)
        runtimeOnly(Dependencies.atomicfuMpp)
    }

    metadata {
        dependenciesMain {
            api(ProjectModules.json)
        }
    }
    metadataDependenciesTest {
        api(ProjectModules.test)
    }
}
