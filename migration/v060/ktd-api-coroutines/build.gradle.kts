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
            api(ProjectModules.Clients.client_coroutines)
            api(ProjectModules.Api_suspend.api_core_suspend)
            api(ProjectModules.Api_suspend.api_user_suspend)
            api(ProjectModules.Api_suspend.api_bots_suspend)
            api(ProjectModules.Api_suspend.api_test_suspend)
            api(ProjectModules.Migration.V060.ktd_api_raw)
        }
    }
}
