plugins {
    use(Plugins.mppAndroidModule)
}

configureMultiplatform(
    useAndroidLibrary = true
)

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
        api(Dependencies.Reactive.reaktive)
    }
    dependenciesTest {
        implementation(Dependencies.kotlin.test)
        implementation(Dependencies.kotlin.annotations)
    }

    metadata {
        dependenciesMain {
            api(ProjectModules.client)
        }
    }
}
