plugins {
    use(Plugins.mppModule)
}
kotlin {
    default()
    jvm {
        dependenciesMain {
            api(Dependencies.kotlin.stdlib)
        }
    }
}
