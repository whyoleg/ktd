plugins {
    use(Plugins.mppModule)
}

configureMultiplatform()

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
//            api(ProjectModules.Clients.client_suspend)
//            api(ProjectModules.Updates.updates_flow)
//            api(ProjectModules.Migration.V060.ktd_client_raw)
        }
    }
}
