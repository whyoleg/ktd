import com.android.build.gradle.*
import org.gradle.api.*
import org.gradle.api.publish.maven.tasks.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.*

fun Project.configureMultiplatform(
    android: Boolean = false
) {
    extensions.configure<KotlinMultiplatformExtension> {
        defaultTargets(android)
        defaultOptions()
    }
    if (android) {
        extensions.configure(LibraryExtension::default)
    }
    tasks.withType<AbstractPublishToMaven> { enabled = false }
}

private fun KotlinMultiplatformExtension.defaultTargets(useAndroidLibrary: Boolean) {
    jvm {
        options { default() }
    }
    if (useAndroidLibrary) {
        android {
            options { default() }
            publishLibraryVariants("debug")
            mavenPublication {
                artifactId = artifactId.substringBeforeLast("-debug")
            }
        }
        sourceSets {
            getByName("androidMain").dependsOn(getByName("jvmMain"))
        }
    }
}
