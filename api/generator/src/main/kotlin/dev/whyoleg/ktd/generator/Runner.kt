package dev.whyoleg.ktd.generator

import org.kohsuke.github.*
import java.io.*

typealias Entity = Pair<String, String>

fun writeEntitiesLocally(entities: List<Entity>) {
    entities.forEach { (path, content) ->
        with(File(path)) {
            parentFile.mkdirs()
            writeText(content)
        }
    }
}

fun GitHub.commitEntities(entities: List<Entity>, apiVersion: String) {
    val repo = getRepository("whyoleg/ktd")
    val devBranch = repo.getBranch("develop")
    println("Create tree")
    val tree =
        repo
            .createTree()
            .baseTree(devBranch.shA1)
            .apply {
                entities.forEach { (path, content) ->
                    val blobSha = repo.createBlob().textContent(content).create().sha
                    println("Create blob for: $path")
                    shaEntry(path, blobSha, false)
                }
            }
            .create()
    println("Tree created: ${tree.sha}")
    val commit =
        repo.createCommit()
            .tree(tree.sha)
            .parent(devBranch.shA1)
            .message("New api version: $apiVersion")
            .create()
    println("Commit created: ${commit.shA1}")
    val ref = repo.createRef("refs/heads/api-v$apiVersion", commit.shA1)
    println("Branch '${ref.ref.substringAfter("refs/heads/")}' created: ${ref.`object`.sha}")
}

fun main() {
    GitHub.connectUsingPassword("whyoleg", "PASSWORD").commitEntities(emptyList(), "test")
}