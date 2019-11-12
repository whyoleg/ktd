package dev.whyoleg.ktd.generator

import org.kohsuke.github.*
import java.io.*

fun readLocalScheme(apiVersion: String): ByteArray = File("api/v$apiVersion/td_api.tl").readBytes()

fun GHCommit.downloadScheme(): ByteArray {
    val content = owner.getFileContent("td/generate/scheme/td_api.tl", shA1)
    println("Scheme sha: ${content.sha}")
    return content.read().readBytes()
}

fun GitHub.downloadScheme(apiVersion: String): ByteArray {
    val query = "Update version to $apiVersion."
    val versionCommit =
        searchCommits()
            .q(query)
            .repo("tdlib/td")
            .list()
            .first { it.commitShortInfo.message.substringBefore("\n") == query }
    println("Commit for version $apiVersion: ${versionCommit.shA1}")
    return versionCommit.downloadScheme()
}

fun GitHub.downloadLatestScheme(): ByteArray = getRepository("tdlib/td").listCommits().first().downloadScheme()
