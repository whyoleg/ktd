plugins {
    use(Plugins.mppModule)
}

configureMultiplatform()
configurePublishing("client-suspend")

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        api(Dependencies.kotlinx.coroutines.core)
    }
    dependenciesTest {
        implementation(Dependencies.kotlin.test)
        implementation(Dependencies.kotlin.annotations)
    }

    metadata {
        dependenciesMain {
            api(ProjectModules.Client.clientCore)
        }
    }
    metadataDependenciesTest {
        api(ProjectModules.test)
    }
}
