plugins {
    use(Plugins.exampleModule)
}

kotlin {
    jvm {
        dependenciesMain {
            implementation(Dependencies.kotlin.stdlib)
            implementation(Dependencies.kotlinx.coroutines.core)
            implementation(ProjectModules.Api.Coroutines.v1_5_4)
        }
    }
}
