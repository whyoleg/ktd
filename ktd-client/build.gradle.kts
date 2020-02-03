plugins {
    use(Plugins.mppModule + Plugins.atomicfuModule)
}

configureMultiplatform()

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        compileOnly(Dependencies.kotlinx.atomicfu.runtime)
    }
    dependenciesTest {
        implementation(Dependencies.kotlin.test)
        implementation(Dependencies.kotlin.annotations)
    }

    metadata {
        dependenciesMain {
            api(ProjectModules.api)
        }
    }
}
