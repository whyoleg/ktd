plugins {
    use(Plugins.mppModule + Plugins.atomicfuModule)
}

configureMultiplatform()
configurePublishing("client-core")

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        compileOnly(Dependencies.atomicfuMpp)
    }
    dependenciesTest {
        implementation(Dependencies.kotlin.test)
        implementation(Dependencies.kotlin.annotations)
        runtimeOnly(Dependencies.atomicfuMpp)
    }

    metadata {
        dependenciesMain {
            api(ProjectModules.core)
        }
    }
    metadataDependenciesTest {
        api(ProjectModules.test)
    }
}
