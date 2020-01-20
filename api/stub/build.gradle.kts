plugins {
    use(Plugins.mppModule)
}

configureMultiplatform(publishable = false)

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
    }
}
