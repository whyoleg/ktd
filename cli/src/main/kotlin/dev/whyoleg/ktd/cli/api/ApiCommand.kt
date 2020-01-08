package dev.whyoleg.ktd.cli.api

import dev.whyoleg.ktd.cli.*
import io.github.cdimascio.dotenv.*
import kotlinx.cli.*
import java.io.*

@UseExperimental(ExperimentalCli::class)
object ApiCommand : DotenvCommand("api") {
    private val version by option(ArgType.String, "version", "v", "Version of tdlib").required()

    private val androidManifest = """
        <?xml version="1.0" encoding="utf-8"?>
        <manifest package="dev.whyoleg.ktd"/>
    """.trimIndent()

    private val dirs = listOf("coroutines", "lib", "raw")

    override suspend fun execute(dotenv: Dotenv) {
        println("Generate api for tdlib $version")
        val scheme = gitHub().downloadScheme(version)
        println("Scheme downloaded")
        val apiEntities = generateApi(scheme, version).toList()

        val buildEntities = dirs.map(this::buildEntity)
        val androidEntities = dirs.map(this::androidEntity)

        val entities = apiEntities + buildEntities + androidEntities
        println("Entities generated")
        writeEntities(entities)
        println("New api saved")
    }

    private fun buildEntity(dir: String) =
        apiPath(dir, version, "build.gradle.kts") to "configure${dir.capitalize()}Api()\n"

    private fun androidEntity(dir: String) =
        apiPath(dir, version, "src/androidMain/AndroidManifest.xml") to androidManifest

    private fun cleanupFiles() {
        dirs.forEach {
            File(apiPath(it, version, "src")).also { println(it.absolutePath) }.deleteRecursively()
        }
    }

    private fun writeEntities(entities: List<Pair<String, String>>) {
        cleanupFiles()
        entities.forEach { (path, content) ->
            println("Create file: $path")
            with(File(path)) {
                parentFile.mkdirs()
                writeText(content)
            }
        }
    }

}
