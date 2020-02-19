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
            api(ProjectModules.Api_suspend.api_core_suspend)
            api(ProjectModules.Api.api_test)
        }
    }
}
