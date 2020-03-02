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
    dependenciesTest {
        implementation(Dependencies.kotlin.test)
        implementation(Dependencies.kotlin.annotations)
    }

    metadata {
        dependenciesMain {
            api(ProjectModules.client)
        }
    }
}
