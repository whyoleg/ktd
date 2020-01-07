import dev.whyoleg.kamp.modules.*
import dev.whyoleg.kamp.publication.*
import org.gradle.api.*
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.config.*
import org.jetbrains.kotlin.gradle.dsl.*
import org.jetbrains.kotlin.gradle.plugin.*

val publication = Publication(
    name = "ktd",
    description = "Kotlin wrapper on TDLib",
    licenses = listOf(License.apache2),
    developers = listOf(Developer("whyoleg", "Oleg", "whyoleg@gmail.com")),
    labels = listOf("Kotlin", "Telegram"),
    url = "https://github.com/whyoleg/ktd",
    vcsUrl = "https://github.com/whyoleg/ktd"
)

private fun KotlinCommonOptions.default() {
    progressive()
    languageVersion = "1.3"
    apiVersion = "1.3"
    enableLanguageFeatures(listOf(LanguageFeature.InlineClasses, LanguageFeature.NewInference))
    useExperimentalAnnotations(KotlinExperimentalAnnotations.All + KotlinxExperimentalAnnotations.All)
}

private fun LanguageSettingsBuilder.default() {
    progressiveMode = true
    languageVersion = "1.3"
    apiVersion = "1.3"
    enableLanguageFeatures(listOf(LanguageFeature.InlineClasses, LanguageFeature.NewInference))
    useExperimentalAnnotations(KotlinExperimentalAnnotations.All + KotlinxExperimentalAnnotations.All)
}

private fun KotlinJvmOptions.default() {
    jvmTarget = "1.6"
}

fun KotlinJvmProjectExtension.default() {
    target {
        commonOptions(KotlinCommonOptions::default)
        options { default() }
    }
}

fun KotlinMultiplatformExtension.defaultPublication(project: Project) {
    targets.all {
        mavenPublication {
            if ("metadata" in artifactId) {
                artifactId = artifactId.replace("-metadata", "")
            }
            val apiVersion = project.name.substringAfterLast("v", "")
            if (artifactId.startsWith("api") && apiVersion.isNotBlank() && apiVersion.split('.').size == 3) {
                artifactId = artifactId.replace("-v$apiVersion", "")
                version = "$version-$apiVersion"
            }
            artifactId = "ktd-$artifactId"
            println(artifactId)
        }
    }
}

fun KotlinMultiplatformExtension.default(project: Project) {
    jvm {
        options { default() }
    }
    android {
        publishLibraryVariants("release")
    }

    defaultPublication(project)

    sourceSets {
        val androidMain by getting
        val jvmMain by getting
        androidMain.dependsOn(jvmMain)
    }

    project.afterEvaluate { defaultOptions() }
}

private fun KotlinMultiplatformExtension.defaultOptions() {
    targets.all { commonOptions(KotlinCommonOptions::default) }
    sourceSets.all { languageSettings.apply(LanguageSettingsBuilder::default) }
}
