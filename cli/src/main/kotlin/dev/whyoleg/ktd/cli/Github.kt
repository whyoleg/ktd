package dev.whyoleg.ktd.cli

import eu.jrie.jetbrains.kotlinshell.shell.*
import org.kohsuke.github.*
import java.io.*

val tdVersionRefs = mapOf(
    "1.5.0" to "e2734d4fb6815da5f357da4731d3013f64410e6b",
    "1.5.1" to "9b0530e704158e56384e9b692590a9227e0cba83",
    "1.5.2" to "1f6f920a7d8093b045c84015ad026ab0169160fd",
    "1.5.3" to "917a3af6acda14f6cecafa9e3fbaaa134675cef5",
    "1.5.4" to "cae329a5bd585beb17e66455c69856e389013363"
)

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
