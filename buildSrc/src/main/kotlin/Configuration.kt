import dev.whyoleg.kamp.modules.*
import dev.whyoleg.kamp.publication.*
import org.jetbrains.kotlin.config.*
import org.jetbrains.kotlin.gradle.dsl.*
import org.jetbrains.kotlin.gradle.targets.jvm.*

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

private fun KotlinJvmOptions.default() {
    jvmTarget = "1.6"
}

fun KotlinMultiplatformExtension.default() {
//    android().compilations["main"].defaultSourceSet.dependsOn(jvm().compilations["main"].defaultSourceSet)
    targets.all {
        commonOptions(KotlinCommonOptions::default)
        if (this is KotlinJvmTarget) options { default() }
    }
}

fun KotlinJvmProjectExtension.default() {
    target {
        commonOptions(KotlinCommonOptions::default)
        options { default() }
    }
}
