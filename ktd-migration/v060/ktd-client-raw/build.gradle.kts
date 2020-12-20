plugins {
    ids(Plugins.mpp) //TODO +android?
}

configureMultiplatform()
//configurePublishing("client-raw")

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
    }
    kampCommonMain.dependencies {
        api(KampModules.core)
    }
}
