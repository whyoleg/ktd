package dev.whyoleg.ktd.cli

import org.kohsuke.github.*

fun gitHub(): GitHub = GitHub.connectAnonymously()

fun GitHub.downloadFile(version: String, filePath: String): ByteArray {
    val commitSha = tdVersionRefs[version] ?: error("There is no '$version' version of TdLib")
    println("Downloading '$filePath' for TdLib version '$version' with sha '$commitSha'")
    val content = getRepository("tdlib/td").getFileContent(filePath, commitSha)
    val scheme = content.read().readBytes()
    println("Scheme '$version' downloaded")
    return scheme
}

fun GitHub.downloadScheme(version: String): ByteArray = downloadFile(version, "td/generate/scheme/td_api.tl")

fun GitHub.downloadTdCpp(version: String): ByteArray = downloadFile(version, "td/telegram/Td.cpp")