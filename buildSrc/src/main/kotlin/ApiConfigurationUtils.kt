import com.android.build.gradle.*
import dev.whyoleg.kamp.project.*
import org.gradle.api.*
import org.gradle.jvm.tasks.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.*

fun Project.configureRawApi() {
    Plugins.mppModule.forEach { (name) -> plugins.apply(name) }
    configureMultiplatform()
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
    Plugins.mppModule.forEach { (name) -> plugins.apply(name) }
    configureMultiplatform()
    extensions.configure<KotlinMultiplatformExtension> {
        dependenciesMain {
            api(Dependencies.kotlin.stdlib)
            api(Dependencies.kotlinx.coroutines.core)
        }
        metadata {
            dependenciesMain {
                api(ProjectModules.Client.coroutines)
                api(ProjectModule(":api-raw-v${project.apiVersion}"))
            }
        }
    }
}

fun Project.configureLibApi() {
    Plugins.mppModule.forEach { (name) -> plugins.apply(name) }
    configureMultiplatform()

    extensions.configure<LibraryExtension> {
        sourceSets["main"].jniLibs.srcDir("src/androidMain/jniLibs")
    }

    tasks.named<Jar>("jvmJar") {
        from(file("src/jvmMain/jniLibs")) { into("libs") }
    }
}