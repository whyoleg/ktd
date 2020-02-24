plugins {
    use(Plugins.mppAndroidModule)
}

configureMultiplatform(
    useAndroidLibrary = true,
    publishable = false
)

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
                implementation(ProjectModules.Api.api_test)
            } else {
                implementation(Dependencies.ktdApiTest(tdIntegrationVersion))
            }
        }
    }
    sourceSets.getByName("androidTest").dependencies {
        implementation("com.android.support.test:runner:1.0.2")
    }

}
