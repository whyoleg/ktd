package dev.whyoleg.ktd.generator

import org.kohsuke.github.*

fun main(vararg args: String) {
    val (apiVersion, read, write) = when (args.size) {
        3    -> {
            val (apiVersion, read, write) = args
            Triple(apiVersion, read, write)
        }
        2    -> {
            val (apiVersion, read) = args
            Triple(apiVersion, read, "l")
        }
        1    -> {
            Triple(args.first(), "l", "l")
        }
        else -> {
            print("Provide api version: ")
            val apiVersion = readLine()!!
            print("Provide read flag: ")
            val read = readLine()!!
            print("Provide write flag: ")
            val write = readLine()!!
            Triple(apiVersion, read, write)
        }
    }
    val github by lazy {
        GitHub.connectAnonymously()
    }
    val scheme = when (read) {
        "l"  -> readLocalScheme(apiVersion)
        "g"  -> github.downloadScheme(apiVersion)
        else -> {
            println("Wrong input")
            return
        }
    }
    println("Scheme exist")
    val entities: List<Entity> = generateEntities(scheme, apiVersion)
    println("Entities generated")
    when (write) {
        "l"  -> writeEntitiesLocally(entities)
        "g"  -> github.commitEntities(entities, apiVersion)
        else -> {
            println("Wrong input")
            return
        }
    }
    println("New api saved")
}

fun generateEntities(scheme: ByteArray, apiVersion: String): List<Entity> =
    (generateApi(scheme).toList() + listOf(
        "td_api.tl" to scheme.toString(Charsets.UTF_8),
        "build.gradle.kts" to "configureApi(\"$apiVersion\")"
    )).map { "api/v$apiVersion/${it.first}" to it.second }
