plugins {
    ids(Plugins.mpp) //TODO +android?
}

configureMultiplatform()
//configureApiPublishing("api-coroutines")

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
    }
    kampCommonMain.dependencies {
        api(KampModules.Client.clientCoroutines)
        api(KampModules.Api.apiCoreSuspend)
        api(KampModules.Api.apiUserSuspend)
        api(KampModules.Api.apiBotsSuspend)
        api(KampModules.Api.apiTestSuspend)
        api(KampModules.Migration.V060.apiRaw)
    }
}
