plugins {
    use(Plugins.exampleModule)
}

kotlin {
    jvm {
        dependenciesMain {
            implementation(Dependencies.kotlin.stdlib)
            implementation(Dependencies.kotlinx.coroutines.core)
            implementation(KampModules.Api.Coroutines.v1_5_4)
        }
    }
}
