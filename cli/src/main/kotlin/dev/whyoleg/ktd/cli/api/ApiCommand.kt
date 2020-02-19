package dev.whyoleg.ktd.cli.api

import kotlinx.cli.*
import java.io.*

@UseExperimental(ExperimentalCli::class)
class ApiCommand : Subcommand("api") {
    private val version by option(ArgType.String, "version", "v", "Version of TdLib").required()

    private fun getAndroidManifest(type: String) = """
        <?xml version="1.0" encoding="utf-8"?>
        <manifest package="dev.whyoleg.ktd.api.$type"/>
    """.trimIndent()

    private val types = listOf("coroutines", "lib", "raw")

    override fun execute() {
        //        println("Generate api for TdLib $version")
        //        val scheme = gitHub().downloadScheme(version)
        //        println("Scheme downloaded")
        //        val apiEntities = generateApi(scheme, version).toList()
        //
        //        val buildEntities = types.map(this::buildEntity)
        //        val androidEntities = types.map(this::androidEntity)
        //
        //        val entities = apiEntities + buildEntities + androidEntities
        //        println("Entities generated")
        //        writeEntities(entities)
        //        println("New api saved")
    }

    private fun apiPath(module: String, version: String, path: String): String = "api/$module/v$version/$path"

    private fun buildEntity(type: String) =
        apiPath(type, version, "build.gradle.kts") to "configure${type.capitalize()}Api()\n"

    private fun androidEntity(type: String) =
        apiPath(type, version, "src/androidMain/AndroidManifest.xml") to getAndroidManifest(type)

    private fun cleanupFiles() {
        types.forEach {
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
