import dev.whyoleg.kamp.project.*

plugins {
    use(Plugins.mppAndroidModule)
}

configureMultiplatform(
    useAndroidLibrary = true,
    publishable = false
)

val tdIntegrationVersion = properties["tdIntegrationVersion"]?.toString()
val tdOnlyVersion = properties["tdOnlyVersion"]?.toString() ?: "1.5.0"

kotlin {
    dependenciesMain {
        implementation(Dependencies.kotlin.stdlib)
        implementation(Dependencies.kotlin.test)
        implementation(Dependencies.kotlin.annotations)
    }
    metadata {
        dependenciesMain {
            if (tdIntegrationVersion == null) {
                implementation(ProjectModule(":api-coroutines-v$tdOnlyVersion"))
            } else {
                implementation(Dependencies.ktdApiCoroutines(tdIntegrationVersion))
            }
        }
    }
    sourceSets.getByName("androidTest").dependencies {
        implementation("com.android.support.test:runner:1.0.2")
    }

}
