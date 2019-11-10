package dev.whyoleg.ktd.generator

import dev.whyoleg.ktd.generator.builder.*
import dev.whyoleg.ktd.generator.tl.*
import dev.whyoleg.ktd.generator.tl.parser.*
import java.io.*

fun main(vararg args: String) {
    val apiVersion = if (args.isEmpty()) readLine()!!
    else {
        require(args.size == 1)
        args.first()
    }
    val apiDir = File("api/v${apiVersion}")
    val schemeFile = apiDir.resolve("td_api.tl")
    val outputDir = apiDir.resolve("src/main/kotlin/dev/whyoleg/ktd/api")
    val tlData = schemeFile.readTlScheme().parseTlData()
    val metadata = tlData.extractMetadata()
    val scheme = TlScheme(tlData, metadata)
    val functionsMap = tlData.groupFunctions()
    val syncFunctions = tlData.filterIsInstance<TlFunction>().filter { TlAddition.Sync in it.metadata.additions }
    with(outputDir) {
        deleteRecursively()
        mkdirs()
        file("Experimental") {
            buildExperimental()
        }
        file("TdApi") {
            buildApi(scheme)
        }
        functionsMap.forEach { (type, functions) ->
            with(resolve(type.decapitalize())) {
                mkdirs()
                file("Raw") {
                    buildRawFunctions(type, functions)
                }
                file("Parameterized") {
                    buildFunctions(type, functions, metadata)
                }
            }
        }
        with(resolve("sync")) {
            mkdirs()
            file("Raw") {
                buildRawSyncFunctions(syncFunctions)
            }
            file("Parameterized") {
                buildSyncFunctions(syncFunctions, metadata)
            }
        }
    }
}

fun File.file(name: String, block: StringBuilder.() -> Unit) {
    resolve("$name.kt").writeText(buildString(block))
}
