package dev.whyoleg.ktd.generator

import kotlinx.coroutines.*
import org.kohsuke.github.*
import java.io.*

fun readLocalScheme(apiVersion: String): ByteArray = File("api/v$apiVersion/td_api.tl").readBytes()

fun GHCommit.downloadScheme(): ByteArray {
    val content = owner.getFileContent("td/generate/scheme/td_api.tl", shA1)
    println("Scheme sha: ${content.sha}")
    return content.read().readBytes()
}

fun GitHub.findCommit(apiVersion: String): GHCommit {
    val query = "Update version to $apiVersion."
    GlobalScope.launch {
        val it = getRepository("tdlib/td").listCommits().first()
        println("LAST found: ${it.commitShortInfo.message}")
        println("LAST sha: ${it.shA1}")
    }
    val versionCommit =
        searchCommits()
            .q(query)
            .repo("tdlib/td")
            .list()
            .first {
                println("Commit found: ${it.commitShortInfo.message}")
                println("sha: ${it.shA1}")
                it.commitShortInfo.message.substringBefore("\n") == query
            }
    println("Commit for version $apiVersion: ${versionCommit.shA1}")
    return versionCommit
}

fun GitHub.downloadScheme(apiVersion: String): ByteArray = findCommit(apiVersion).downloadScheme()

fun GitHub.downloadLatestScheme(): ByteArray = getRepository("tdlib/td").listCommits().first().downloadScheme()
