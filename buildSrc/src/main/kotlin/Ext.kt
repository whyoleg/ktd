import dev.whyoleg.kamp.*
import dev.whyoleg.kamp.configuration.*
import dev.whyoleg.kamp.ext.*
import dev.whyoleg.kamp.publishing.*
import dev.whyoleg.kamp.settings.*
import org.gradle.api.*
import org.gradle.api.tasks.bundling.*
import java.net.*
import java.net.http.*
import java.util.*
import java.util.concurrent.*

private const val jdk = "1.6"

private val defaultConfiguration = ProjectConfiguration("dev.whyoleg.ktd", "", "0.5.0-pre-android-2")

private val defaultPublication = Publication(
    name = "ktd",
    description = "Kotlin wrapper on TDLib",
    licenses = listOf(License("Apache-2.0", "http://www.apache.org/licenses/LICENSE-2.0.txt", "repo")),
    developers = listOf(Developer("whyoleg", "Oleg", "whyoleg@gmail.com")),
    labels = listOf("Kotlin", "Telegram"),
    scmConnections = "scm:git:git@github.com:whyoleg/ktd.git",
    vcsUrl = "https://github.com/whyoleg/ktd",
    websiteUrl = "https://github.com/whyoleg/ktd",
    githubUrl = ""
)

@KampDSL
fun Project.configure(configuration: ProjectConfiguration? = null, block: KampJvmExtension.() -> Unit = {}) {
    kampJvm(configuration) {
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
}

@KampDSL
fun Project.configure(artifact: String, block: KampJvmExtension.() -> Unit = {}) {
    configure(defaultConfiguration.copy(artifact = "ktd-$artifact")) {
        apply(block)
        publishing { bintray(artifact) }
    }
}

fun PublishersBuilder.bintray(artifact: String) {
    bintray(defaultPublication.copy(name = "ktd-$artifact")) {
        repo = "ktd"
        autoPublish = false
    }
}

private fun Project.configureVersion(artifact: String, version: String, block: KampJvmExtension.() -> Unit = {}) {
    configure("$artifact-v$version") {
        apply(block)
        if (version == Versions.tdLatest) publishing { bintray("$artifact-latest") }
    }
}

fun Project.configureCoroutinesApi(version: String) {
    configureVersion("coroutines-api", version) {
        source {
            main {
                api {
                    +Dependencies.kotlin.stdlib
                    +Dependencies.coroutines.core
                    +Modules.Client.coroutines
                    +Modules.Api[version].raw
                }
            }
        }
    }
}

fun Project.configureRawApi(version: String) {
    configureVersion("raw-api", version) {
        source {
            main {
                api {
                    +Dependencies.kotlin.stdlib
                    +Modules.Client.raw
//                    +Modules.Api[version].lib
                }
            }
        }
    }
}

fun Project.configureLib(version: String) {
    configureVersion("lib", version)
    //TODO move it to kamp
    tasks.named("jar", Jar::class.java) {
        from(rootDir.resolve("libs/$version")) {
            include("**/*tdjni*")
            into("libs")
        }
    }
}

fun Project.registerTasks() {
    tasks.register("publishBintrayRelease") {
        doLast {
            val client = HttpClient.newHttpClient()
            val bintrayUser = System.getenv("bintray_user")
            val bintrayKey = System.getenv("bintray_key")
            val version = defaultConfiguration.version(this@registerTasks)
            val basic = "Basic " + Base64.getEncoder().encodeToString("$bintrayUser:$bintrayKey".toByteArray())
            val builder = HttpRequest.newBuilder().header("Authorization", basic).POST(HttpRequest.BodyPublishers.noBody())
            subprojects
                .flatMap { project ->
                    project.tasks.mapNotNull {
                        if (
                            it.name.startsWith("publish") &&
                            it.name.endsWith("PublicationToMavenLocal")
                        ) it.name.substringAfter("publish").substringBefore("PublicationToMavenLocal").toLowerCase()
                        else null
                    }
                }
                .map { builder.uri(URI.create("https://api.bintray.com/content/whyoleg/ktd/$it/$version/publish")).build() }
                .map { client.sendAsync(it, HttpResponse.BodyHandlers.discarding()) }.toTypedArray()
                .let { CompletableFuture.allOf(*it) }
                .get()
        }
    }
}
