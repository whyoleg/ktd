plugins {
    ids(Plugins.mpp) //TODO +android?
}

configureMultiplatform()
//configureApiPublishing("api-raw")

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
    }
    kampCommonMain.dependencies {
        api(KampModules.Api.apiCore)
        api(KampModules.Api.apiUser)
        api(KampModules.Api.apiBots)
        api(KampModules.Api.apiTest)
        api(KampModules.Migration.V060.clientRaw)
    }
}
