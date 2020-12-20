plugins {
    ids(Plugins.mppWithAtomic)
}

configureMultiplatform()

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        compileOnly(Dependencies.atomicfuMetadata)
    }
    kampCommonMain.dependencies {
        api(KampModules.client)
    }
}
