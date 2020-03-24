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
            api(ProjectModules.Client.clientCoroutines)
            api(ProjectModules.Api.apiCoreSuspend)
            api(ProjectModules.Api.apiUserSuspend)
            api(ProjectModules.Api.apiBotsSuspend)
            api(ProjectModules.Api.apiTestSuspend)
            api(ProjectModules.Migration.V060.apiRaw)
        }
    }
}
