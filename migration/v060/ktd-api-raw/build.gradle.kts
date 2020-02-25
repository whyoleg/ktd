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
            api(ProjectModules.Api.api_user)
            api(ProjectModules.Api.api_bots)
            api(ProjectModules.Api.api_test)
            api(ProjectModules.Migration.V060.ktd_client_raw)
        }
    }
}
