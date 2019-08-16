import dev.whyoleg.kamp.*
import dev.whyoleg.kamp.ext.*
import dev.whyoleg.kamp.settings.*
import org.gradle.api.*

fun Project.kampJvmCommon(block: KampJvmExtension.() -> Unit) = kampJvm(Versions.builtIn) {
    options {
        jvmTarget = Versions.jdk
        sourceCompatibility = Versions.jdk
        targetCompatibility = Versions.jdk
    }
    languageSettings {
        progressiveMode = true
        languageFeatures += LanguageFeature.values()
        experimentalAnnotations += ExperimentalAnnotation.values()
    }
    apply(block)
}