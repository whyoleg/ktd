import dev.whyoleg.kamp.modules.*
import org.jetbrains.kotlin.config.*
import org.jetbrains.kotlin.gradle.dsl.*
import org.jetbrains.kotlin.gradle.plugin.*

fun KotlinCommonOptions.default() {
    progressive()
    languageVersion = "1.3"
    apiVersion = "1.3"
    enableLanguageFeatures(listOf(LanguageFeature.InlineClasses, LanguageFeature.NewInference))
    useExperimentalAnnotations(KotlinExperimentalAnnotations.All + KotlinxExperimentalAnnotations.All)
}

fun LanguageSettingsBuilder.default() {
    progressiveMode = true
    languageVersion = "1.3"
    apiVersion = "1.3"
    enableLanguageFeatures(listOf(LanguageFeature.InlineClasses, LanguageFeature.NewInference))
    useExperimentalAnnotations(KotlinExperimentalAnnotations.All + KotlinxExperimentalAnnotations.All)
}

fun KotlinJvmOptions.default() {
    jvmTarget = "1.6"
}

fun KotlinMultiplatformExtension.defaultOptions() {
    targets.first().project.afterEvaluate {
        targets.all { commonOptions(KotlinCommonOptions::default) }
        sourceSets.all { languageSettings.apply(LanguageSettingsBuilder::default) }
    }
}
