plugins {
    use(Plugins.mppModule)
}

android { default() }

kotlin {
    configureMultiplatform()
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        api(ProjectModules.Lib.v1_5_0)
    }
}
