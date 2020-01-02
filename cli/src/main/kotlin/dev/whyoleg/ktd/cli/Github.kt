package dev.whyoleg.ktd.cli

import eu.jrie.jetbrains.kotlinshell.shell.*
import kotlinx.coroutines.*
import org.kohsuke.github.*
import java.io.*

val versionCommits = mapOf(
    "1.5.0" to "e2734d4fb6815da5f357da4731d3013f64410e6b",
    "1.5.1" to "9b0530e704158e56384e9b692590a9227e0cba83",
    "1.5.2" to "ecc856a52c1f932e06c2ef87bdb1bd9a99b1ac9f",
    "1.5.3" to "5fd1339bc1a2cadb8c52b61f2a4e5ccca8d0c41f",
    "1.5.4" to "47c4d4267464c0b5709a9037ec2a49150f3de701"
)

val versions = versionCommits.keys.sorted()

suspend fun gitHub(): GitHub = withContext(Dispatchers.IO) { GitHub.connectAnonymously() }

suspend fun GitHub.downloadScheme(version: String): ByteArray = withContext(Dispatchers.IO) {
    val commitSha = versionCommits[version] ?: error("There is no '$version' version of tdlib")
    println("Downloading scheme for tdlib version '$version' with sha '$commitSha'")
    val content = getRepository("tdlib/td").getFileContent("td/generate/scheme/td_api.tl", commitSha)
    val scheme = content.read().readBytes()
    println("Scheme '$version' downloaded")
    scheme
}

//TODO remove it, use workflow
suspend fun checkoutVersion(version: String) {
    val commitSha = versionCommits[version] ?: error("There is no '$version' version of tdlib")
    shell(dir = File("td")) { "git reset --hard $commitSha"() }
}
