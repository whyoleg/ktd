import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.*
import org.jetbrains.kotlin.gradle.plugin.*

fun KotlinJvmProjectExtension.default() {
    target {
        commonOptions(KotlinCommonOptions::default)
        options { default() }
    }
    sourceSets.all {
        languageSettings.apply(LanguageSettingsBuilder::default)
    }
}

fun KotlinMultiplatformExtension.configureMultiplatform() {
    jvm {
        options { default() }
    }
    android {
        publishLibraryVariants("release")
    }

    sourceSets {
        val androidMain by getting
        val jvmMain by getting
        androidMain.dependsOn(jvmMain)
    }

    targets.first().project.run { configurePublishing() }
    defaultOptions()
}
