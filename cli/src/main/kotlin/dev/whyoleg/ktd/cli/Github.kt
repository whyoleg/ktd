package dev.whyoleg.ktd.cli

import org.kohsuke.github.*

val tdVersionRefs = mapOf(
    "1.5.0" to "e2734d4fb6815da5f357da4731d3013f64410e6b",
    "1.5.1" to "9b0530e704158e56384e9b692590a9227e0cba83",
    "1.5.2" to "ab534a9e773b950dd5fc7142d9862b2f0067862b",
    "1.5.3" to "6bfb4a79f29cb55d14a42e1dc667a019b0056b9c",
    "1.5.4" to "b7928e64a68194d97011e4f3f015be65a0fbe8ca"
)

val tdVersions = tdVersionRefs.keys.sorted()

fun gitHub(): GitHub = GitHub.connectAnonymously()

fun GitHub.downloadScheme(version: String): ByteArray {
    val commitSha = tdVersionRefs[version] ?: error("There is no '$version' version of TdLib")
    println("Downloading scheme for TdLib version '$version' with sha '$commitSha'")
    val content = getRepository("tdlib/td").getFileContent("td/generate/scheme/td_api.tl", commitSha)
    val scheme = content.read().readBytes()
    println("Scheme '$version' downloaded")
    return scheme
}
