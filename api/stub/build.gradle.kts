plugins {
    use(Plugins.mppModule)
}

android { default() }

kotlin {
    configureMultiplatform()
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
    }
}
