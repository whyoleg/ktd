import dev.whyoleg.kamp.publication.*
import dev.whyoleg.kamp.publication.Publication
import org.gradle.api.*
import org.gradle.api.publish.*
import org.gradle.api.publish.maven.*

val publication = Publication(
    name = "ktd",
    description = "Kotlin wrapper on TDLib",
    licenses = listOf(License.apache2),
    developers = listOf(Developer("whyoleg", "Oleg", "whyoleg@gmail.com")),
    labels = listOf("Kotlin", "Telegram"),
    url = "https://github.com/whyoleg/ktd",
    vcsUrl = "https://github.com/whyoleg/ktd"
)

val ktdPublisher = BintrayPublisher("whyoleg", "ktd", "ktd")
val cliPublisher = ktdPublisher.copy(name = "cli")
val libPublisher = ktdPublisher.copy(name = "lib")

fun Project.configurePublishing() = afterEvaluate {
    val publisher = when {
        name.startsWith("lib") -> {
            version = ProjectVersions.lib
            libPublisher
        }
        name.startsWith("cli") -> {
            version = ProjectVersions.cli
            cliPublisher
        }
        else                   -> {
            version = ProjectVersions.ktd
            ktdPublisher
        }
    }

    val props = (properties["publishOnly"] as String?)?.split(",")
    val needToPublish = props == null || when {
        project.name.startsWith("lib") && "lib" in props -> true
        project.name.startsWith("cli") && "lib" in props -> true
        "ktd" in props                                   -> true
        else                                             -> false
    }

    extensions.configure<PublishingExtension>("publishing") {
        val apiVersion =
            name
                .substringAfterLast("v", "")
                .takeIf(String::isNotBlank)
                ?.takeIf { it.split('.').size == 3 }

        repositories {
            publisher.provider()(this)
        }
        publications.all {
            this as MavenPublication
            pom(publication)

            artifactId = "ktd-$artifactId"

            if (apiVersion != null) {
                artifactId = artifactId.replace("-v$apiVersion", "")
                version = "$version-$apiVersion"
            }
        }
    }
}