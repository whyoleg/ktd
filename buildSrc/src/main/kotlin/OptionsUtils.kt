import org.jetbrains.kotlin.gradle.plugin.*

fun LanguageSettingsBuilder.default() {
    progressiveMode = true
    languageVersion = "1.3"
    apiVersion = "1.3"

    enableLanguageFeature("NewInference")
    enableLanguageFeature("InlineClasses")
}
