plugins {
    use(Plugins.mppModule)
}

kotlin {
    default()
    jvm {
        dependenciesMain {
            api(Dependencies.kotlin.stdlib)
            api(Dependencies.kotlinx.coroutines.core)
            api(ProjectModules.Client.coroutines)
            api(ProjectModules.Api.Raw.v1_5_0)
        }
    }
}
