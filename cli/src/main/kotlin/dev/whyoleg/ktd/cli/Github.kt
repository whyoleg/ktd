package dev.whyoleg.ktd.cli

import eu.jrie.jetbrains.kotlinshell.shell.*
import kotlinx.serialization.json.*
import org.kohsuke.github.*
import java.io.*

val tdVersionRefs =
    Json(JsonConfiguration.Stable)
        .parseJson(File("tdVersions.json").readText())
        .jsonObject
        .toMap()
        .mapValues { it.value.primitive.content }

val tdVersions = tdVersionRefs.keys.sorted()

fun gitHub(): GitHub = GitHub.connectAnonymously()

fun GitHub.downloadScheme(version: String): ByteArray {
    val commitSha = tdVersionRefs[version] ?: error("There is no '$version' version of tdlib")
    println("Downloading scheme for tdlib version '$version' with sha '$commitSha'")
    val content = getRepository("tdlib/td").getFileContent("td/generate/scheme/td_api.tl", commitSha)
    val scheme = content.read().readBytes()
    println("Scheme '$version' downloaded")
    return scheme
}

//TODO remove it, use workflow
suspend fun checkoutVersion(version: String) {
    val commitSha = tdVersionRefs[version] ?: error("There is no '$version' version of tdlib")
    shell(dir = File("td")) { "git reset --hard $commitSha"() }
}
