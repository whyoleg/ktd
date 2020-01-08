plugins {
    use(Plugins.mppModule)
}

android { default() }

kotlin {
    configureMultiplatform()
    dependenciesMain {
        api(Dependencies.kotlin.stdlib)
    }
    dependenciesTest {
        implementation(Dependencies.kotlin.test)
        implementation(Dependencies.kotlin.annotations)
    }

    metadata {
        dependenciesMain {
            compileOnly(ProjectModules.Api.stub)
        }
    }
}
