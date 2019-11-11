package dev.whyoleg.ktd.generator

import org.kohsuke.github.*
import java.io.*

fun main(vararg args: String) {
    val apiVersion = if (args.isEmpty()) {
        print("Provide api version: ")
        "1.5.0"
        //        readLine()!!
    } else {
        require(args.size == 1)
        args.first()
    }
    val schemeFile = File("/home/whyme/IdeaProjects/ktd/api/v1.5.1/td_api.tl")
    val entities: List<Entity> = generateEntities(schemeFile, apiVersion)
    //        writeEntitiesLocally(entities)
    GitHub.connectUsingPassword("whyoleg", "PASSWORD").commitEntities(entities, "1.5.0")
}

fun generateEntities(scheme: File, apiVersion: String): List<Entity> =
    (generateApi(scheme.inputStream()).toList() + listOf(
        "td_api.tl" to scheme.readText(),
        "build.gradle.kts" to "configureApi(\"$apiVersion\")"
    )).map { "api/v$apiVersion/${it.first}" to it.second }
