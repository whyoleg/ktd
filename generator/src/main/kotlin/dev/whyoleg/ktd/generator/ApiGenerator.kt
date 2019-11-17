package dev.whyoleg.ktd.generator

import org.kohsuke.github.*

fun main(vararg args: String) {
    val apiVersion = args.first()
    println("Generate api for tdlib $apiVersion")
    val github by lazy { GitHub.connectAnonymously() }
    val scheme = github.downloadScheme(apiVersion)
    println("Scheme downloaded")
    val entities: List<Entity> = generateEntities(scheme, apiVersion)
    println("Entities generated")
    writeEntitiesLocally(entities)
    println("New api saved")
}

fun generateEntities(scheme: ByteArray, apiVersion: String): List<Entity> =
    (generateApi(scheme).toList() + listOf(
        "raw/build.gradle.kts" to "configureRawApi(\"$apiVersion\")\n",
        "coroutines/build.gradle.kts" to "configureCoroutinesApi(\"$apiVersion\")\n"
    )).map { "api/v$apiVersion/${it.first}" to it.second }
