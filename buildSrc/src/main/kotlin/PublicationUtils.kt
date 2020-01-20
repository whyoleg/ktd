import dev.whyoleg.kamp.publication.*
import dev.whyoleg.kamp.publication.Publication
import org.gradle.api.*
import org.gradle.api.publish.*
import org.gradle.api.publish.maven.*
import org.gradle.kotlin.dsl.*

val publication = Publication(
    name = "ktd",
    description = "Kotlin wrapper on TDLib",
    licenses = listOf(License.apache2),
    developers = listOf(Developer("whyoleg", "Oleg", "whyoleg@gmail.com")),
    labels = listOf("Kotlin", "Telegram"),
    url = "https://github.com/whyoleg/ktd",
    vcsUrl = "https://github.com/whyoleg/ktd"
)
private val stubPublisher = BintrayPublisher("whyoleg", "ktd", "")
val ktdClientPublisher = stubPublisher.copy(name = "ktd-client")
val ktdApiPublisher = stubPublisher.copy(name = "ktd-api")
val ktdLibPublisher = stubPublisher.copy(name = "ktd-lib")

fun Project.configurePublishing() = afterEvaluate {
    val publisher = when {
        name.startsWith("client")   -> ktdClientPublisher
        name.startsWith("api-lib-") -> ktdLibPublisher
        else                        -> ktdApiPublisher
    }
    val publishOnly = (properties["publishOnly"] as String?)?.split(",")
    val needToPublish = when {
        publishOnly == null                 -> true
        project.name.startsWith("api-lib-") -> "lib" in publishOnly
        else                                -> "ktd" in publishOnly
    }
    if (needToPublish) {
        extensions.configure<PublishingExtension> {
            repositories {
                publisher.provider()(this)
            }
            val apiVersion = project.apiVersion
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
}
