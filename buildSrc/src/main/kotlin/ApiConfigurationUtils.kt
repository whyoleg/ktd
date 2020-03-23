import dev.whyoleg.kamp.project.*
import org.gradle.api.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.*

fun Project.configureSerialization() {
    Plugins.serializationModule.forEach { (name) -> plugins.apply(name) }
    extensions.configure<KotlinMultiplatformExtension> {
        dependenciesMain {
            api(Dependencies.kotlinx.serialization.runtime)
        }
    }
}

fun Project.configureApi(vararg modules: ProjectModule) {
    Plugins.mppAndroidModule.forEach { (name) -> plugins.apply(name) }
    configureMultiplatform(useAndroidLibrary = true)

    extensions.configure<KotlinMultiplatformExtension> {
        dependenciesMain {
            api(Dependencies.kotlin.stdlib)
        }
        metadata {
            dependenciesMain {
                modules.forEach(::api)
            }
        }
    }
}
