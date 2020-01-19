import com.android.build.gradle.*
import org.gradle.api.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.*
import org.jetbrains.kotlin.gradle.plugin.*

fun Project.configureMultiplatform(useAndroidLibrary: Boolean = false, publishable: Boolean = true) {
    version = properties[when {
        name.startsWith("api-lib-") -> "libVersion"
        else                        -> "version"
    }]!!

    extensions.configure<KotlinMultiplatformExtension> {
        default(useAndroidLibrary, publishable)
    }
    if (useAndroidLibrary) {
        extensions.configure(LibraryExtension::default)
    }
}

fun KotlinJvmProjectExtension.default() {
    target {
        commonOptions(KotlinCommonOptions::default)
        options { default() }
    }
    sourceSets.all {
        languageSettings.apply(LanguageSettingsBuilder::default)
    }
}

fun KotlinMultiplatformExtension.defaultTargets(useAndroidLibrary: Boolean) {
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

fun KotlinMultiplatformExtension.default(useAndroidLibrary: Boolean = false, publishable: Boolean = true) {
    defaultTargets(useAndroidLibrary)
    defaultOptions()
    if(publishable) targets.first().project.run(Project::configurePublishing)
}

val Project.apiVersion
    get() = name.substringAfterLast("v", "").takeIf(String::isNotBlank)?.takeIf { it.split('.').size == 3 }
