package dev.whyoleg.ktd.cli.api

import dev.whyoleg.ktd.cli.*
import io.github.cdimascio.dotenv.*
import kotlinx.cli.*
import java.io.*

@UseExperimental(ExperimentalCli::class)
object ApiCommand : DotenvCommand("api") {
    private val version by option(ArgType.String, "version", "v", "Version of tdlib").required()

    override suspend fun execute(dotenv: Dotenv) {
        println("Generate api for tdlib $version")
        val scheme = gitHub().downloadScheme(version)
        println("Scheme downloaded")
        val apiEntities = generateApi(scheme).toList()
        val buildEntities = listOf(
            buildEntity("coroutines", "CoroutinesApi"),
            buildEntity("lib", "Lib"),
            buildEntity("raw", "RawApi")
        )
        val entities = (apiEntities + buildEntities).map { "api/v$version/${it.first}" to it.second }
        println("Entities generated")
        writeEntitiesLocally(entities)
        println("New api saved")
    }

    private fun buildEntity(dir: String, configuration: String) = "$dir/build.gradle.kts" to "configure$configuration(\"$version\")\n"

    private fun writeEntitiesLocally(entities: List<Pair<String, String>>) {
        entities.forEach { (path, content) ->
            println("Create file: $path")
            with(File(path)) {
                parentFile.mkdirs()
                writeText(content)
            }
        }
    }

}
