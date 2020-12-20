plugins {
    ids(Plugins.mppWithAndroid)
}

configureMultiplatform()
//configureApiPublishing("migration")

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
    }
    kampCommonMain.dependencies {
        api(KampModules.Client.coroutines)
        api(KampModules.Api.apiCoreSuspend)
        api(KampModules.Api.apiUserSuspend)
        api(KampModules.Api.apiBotsSuspend)
        api(KampModules.Api.apiTestSuspend)
        api(KampModules.Migration.V060.apiRaw)
    }
}
