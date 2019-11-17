package dev.whyoleg.ktd.generator

import org.kohsuke.github.*

fun GHCommit.downloadScheme(): ByteArray {
    val content = owner.getFileContent("td/generate/scheme/td_api.tl", shA1)
    println("Scheme sha: ${content.sha}")
    return content.read().readBytes()
}

fun GitHub.findCommit(apiVersion: String): GHCommit {
    val query = "Update version to $apiVersion."
    @Suppress("DEPRECATION")
    val versionCommit =
        searchCommits()
            .q(query)
            .repo("tdlib/td")
            .list()
            .first { it.commitShortInfo.message.substringBefore("\n") == query }
    println("Commit for version $apiVersion: ${versionCommit.shA1}")
    return versionCommit
}

fun GitHub.downloadScheme(apiVersion: String): ByteArray = findCommit(apiVersion).downloadScheme()

fun GitHub.downloadLatestScheme(): ByteArray = getRepository("tdlib/td").listCommits().first().downloadScheme()
