package dev.whyoleg.ktd.cli.api

import dev.whyoleg.ktd.cli.*
import io.github.cdimascio.dotenv.*
import kotlinx.cli.*
import org.kohsuke.github.*

@UseExperimental(ExperimentalCli::class)
object ApiCommand : DotenvCommand("api") {
    private val version by option(ArgType.String, "version", "v", "Version of tdlib").required()

    override suspend fun execute(dotenv: Dotenv) {
        println("Generate api for tdlib $version")
        val github = GitHub.connectAnonymously()
        val scheme = github.downloadScheme(version)
        println("Scheme downloaded")
        val apiEntities: List<Entity> = generateApi(scheme).toList()
        val buildEntities: List<Entity> = listOf(
            buildEntity("coroutines", "CoroutinesApi"),
            buildEntity("lib", "Lib"),
            buildEntity("raw", "RawApi")
        )
        val entities: List<Entity> = (apiEntities + buildEntities).map { "api/v$version/${it.first}" to it.second }
        println("Entities generated")
        writeEntitiesLocally(entities)
        println("New api saved")
    }

    private fun buildEntity(dir: String, configuration: String): Entity =
        "$dir/build.gradle.kts" to "configure$configuration(\"$version\")\n"
}