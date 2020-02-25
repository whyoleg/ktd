plugins {
    use(Plugins.mppModule)
}

configureMultiplatform()

kotlin {
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
    }
    dependenciesTest {
        implementation(Dependencies.kotlin.test)
        implementation(Dependencies.kotlin.annotations)
    }
}