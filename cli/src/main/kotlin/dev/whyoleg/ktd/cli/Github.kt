package dev.whyoleg.ktd.cli

import org.kohsuke.github.*

fun gitHub(): GitHub = GitHub.connectAnonymously()

fun GitHub.downloadScheme(version: String): ByteArray {
    val commitSha = tdVersionRefs[version] ?: error("There is no '$version' version of TdLib")
    println("Downloading scheme for TdLib version '$version' with sha '$commitSha'")
    val content = getRepository("tdlib/td").getFileContent("td/generate/scheme/td_api.tl", commitSha)
    val scheme = content.read().readBytes()
    println("Scheme '$version' downloaded")
    return scheme
}
