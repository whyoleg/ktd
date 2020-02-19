plugins {
    use(Plugins.mppModule)
}

configureMultiplatform()

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
    }
    metadata {
        dependenciesMain {
            api(ProjectModules.Api.api_core)
            api(ProjectModules.Clients.client_suspend)
        }
    }
}
