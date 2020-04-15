plugins {
    use(Plugins.mppModule)
}

configureMultiplatform()
configureApiPublishing("api-raw")

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
    }
    metadata {
        dependenciesMain {
            api(ProjectModules.Api.apiCore)
            api(ProjectModules.Api.apiUser)
            api(ProjectModules.Api.apiBots)
            api(ProjectModules.Api.apiTest)
            api(ProjectModules.Migration.V060.clientRaw)
        }
    }
}
