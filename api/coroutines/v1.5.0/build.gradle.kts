plugins {
    use(Plugins.mppModule)
}

android { default() }

kotlin {
    default(project)
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        api(Dependencies.kotlinx.coroutines.core)
    }
    metadata {
        dependenciesMain {
            api(ProjectModules.Client.coroutines)
            api(ProjectModules.Api.Raw.v1_5_0)
        }
    }
}
