plugins {
    use(Plugins.mppAndroidModule)
}

configureMultiplatform(android = true)

val tdIntegrationVersion = properties["tdIntegrationVersion"]?.toString()

kotlin {
    dependenciesMain {
        implementation(Dependencies.kotlin.stdlib)
        implementation(Dependencies.kotlin.test)
        implementation(Dependencies.kotlin.annotations)
    }
    metadata {
        dependenciesMain {
            if (tdIntegrationVersion == null) {
                implementation(ProjectModules.Api.apiTest)
            } else {
                implementation(Dependencies.ktdApiTest(tdIntegrationVersion))
            }
        }
    }
    sourceSets.getByName("androidTest").dependencies {
        implementation("com.android.support.test:runner:1.0.2")
    }

}
