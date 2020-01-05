plugins {
    use(Plugins.mppModule)
}

kotlin {
    default()
    jvm {
        dependenciesMain {
            implementation(Dependencies.kotlin.stdlib)
            implementation(Dependencies.kotlinx.coroutines.core)
            compileOnly(ProjectModules.Api.Coroutines.v1_5_0)
        }
    }
}
