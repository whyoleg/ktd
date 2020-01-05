plugins {
    use(Plugins.mppModule)
}
kotlin {
    default()
    jvm {
        dependenciesMain {
            api(Dependencies.kotlin.stdlib)
            compileOnly(ProjectModules.Api.stub)
        }
        dependenciesTest {
            implementation(Dependencies.kotlin.test)
            implementation(Dependencies.kotlin.annotations)
        }
    }
}
