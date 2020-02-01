import dev.whyoleg.kamp.project.*
import org.gradle.api.*
import org.gradle.jvm.tasks.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.*

fun Project.configureRawApi() {
    Plugins.mppAndroidModule.forEach { (name) -> plugins.apply(name) }
    configureMultiplatform(true)
    extensions.configure<KotlinMultiplatformExtension> {
        dependenciesMain {
            api(Dependencies.kotlin.stdlib)
        }
        metadata {
            dependenciesMain {
                api(ProjectModule(":api-lib-v${project.apiVersion}"))
            }
        }
    }
}

fun Project.configureCoroutinesApi() {
    Plugins.mppAndroidModule.forEach { (name) -> plugins.apply(name) }
    configureMultiplatform(true)
    extensions.configure<KotlinMultiplatformExtension> {
        dependenciesMain {
            api(Dependencies.kotlin.stdlib)
            api(Dependencies.kotlinx.coroutines.core)
        }
        metadata {
            dependenciesMain {
                //TODO change later
                api(ProjectModule(":client-suspend"))
                api(ProjectModule(":api-typed-v${project.apiVersion}"))
            }
        }
    }
}

fun Project.configureLibApi() {
    Plugins.mppAndroidModule.forEach { (name) -> plugins.apply(name) }
    configureMultiplatform(true)

    tasks.named<Jar>("jvmJar") {
        from(file("src/jvmMain/jniLibs")) { into("libs") }
    }
}
