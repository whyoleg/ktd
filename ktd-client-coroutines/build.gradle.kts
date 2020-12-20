plugins {
    ids(Plugins.mpp)
}

configureMultiplatform()
//configurePublishing("client-suspend")

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        api(Dependencies.kotlinx.coroutines)
    }
    kampCommonMain.dependencies {
        api(KampModules.client)
    }
    kampCommonTest.dependencies {
        api(KampModules.test)
    }
}
