import dev.whyoleg.kamp.*
import dev.whyoleg.kamp.configuration.*
import dev.whyoleg.kamp.ext.*
import dev.whyoleg.kamp.publishing.*
import dev.whyoleg.kamp.settings.*
import org.gradle.api.*

private const val jdk = "1.6"

private val configuration = ProjectConfiguration("dev.whyoleg.ktd", "ktd", "0.3.0")

@KampDSL
fun Project.configuredKamp(configuration: ProjectConfiguration? = null, block: KampJvmExtension.() -> Unit) = kampJvm(configuration) {
    options {
        jvmTarget = jdk
        sourceCompatibility = jdk
        targetCompatibility = jdk
    }
    languageSettings {
        progressiveMode = true
        languageFeatures += LanguageFeature.values()
        experimentalAnnotations += ExperimentalAnnotation.values()
    }
    apply(block)
}

@KampDSL
fun Project.configuredKamp(block: KampJvmExtension.() -> Unit) = configuredKamp(configuration, block)

val publication = Publication(
    name = "ktd",
    description = "Kotlin wrapper on TDLib",
    licenses = listOf(License("Apache-2.0", "http://www.apache.org/licenses/LICENSE-2.0.txt", "repo")),
    developers = listOf(Developer("whyoleg", "Oleg", "whyoleg@gmail.com")),
    labels = listOf("Kotlin", "Telegram"),
    scmConnections = "scm:git:git@github.com:whyoleg/ktd.git",
    vcsUrl = "git@github.com:whyoleg/ktd.git",
    websiteUrl = "https://github.com/whyoleg/ktd",
    githubUrl = "https://github.com/whyoleg/ktd"
)
