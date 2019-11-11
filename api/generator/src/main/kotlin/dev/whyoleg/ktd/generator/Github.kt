package dev.whyoleg.ktd.generator

import org.kohsuke.github.*
import java.io.*

fun main(vararg args: String) {
    val apiVersion = if (args.isEmpty()) {
        print("Provide api version: ")
        readLine()!!
    } else {
        require(args.size == 1)
        args.first()
    }
    val github = GitHub.connectUsingPassword("whyoleg", "PASSWORD")
    println("Connected to api as ${github.myself.name}")
    val newScheme = github.downloadScheme(apiVersion)
    github.commitScheme(apiVersion, newScheme)
}

fun GitHub.commitScheme(apiVersion: String, newScheme: InputStream) {
    val branchName = "api-scheme-v$apiVersion"
    val repo = getRepository("whyoleg/ktd")
    val devBranch = repo.getBranch("develop")
    repo
        .runCatching { createRef("refs/heads/$branchName", devBranch.shA1) }
        .onSuccess { println("Branch '${it.ref.substringAfter("refs/heads/")}' created") }
        .onFailure { println("Branch exists") }
    val update =
        repo.createContent()
            .branch(branchName)
            .path("api/v$apiVersion/td_api.tl")
            .content(newScheme.readBytes())
            .message("Scheme for api version: $apiVersion")
            .commit()
    println("Scheme commit: ${update.commit.shA1}")
}

fun GHCommit.downloadScheme(): InputStream {
    val content = owner.getFileContent("td/generate/scheme/td_api.tl", shA1)
    println("Scheme sha: ${content.sha}")
    return content.read()
}

fun GitHub.downloadScheme(apiVersion: String): InputStream {
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

fun GitHub.downloadLatestScheme(): InputStream = getRepository("tdlib/td").listCommits().first().downloadScheme()
