package dev.whyoleg.ktd.generator

import dev.whyoleg.ktd.generator.builder.*
import dev.whyoleg.ktd.generator.tl.*
import dev.whyoleg.ktd.generator.tl.parser.*
import java.io.*

fun main() {
    val schemeFile = File("td/td/generate/scheme/td_api.tl")
    val outputDir = File("library/src/main/kotlin/dev/whyoleg/ktd/api")
    val tlData = schemeFile.readTlScheme().parseTlData()
    val metadata = tlData.extractMetadata()
    val scheme = TlScheme(tlData, metadata)
    val functionsMap = tlData.groupFunctions()
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
    }
}

fun File.file(name: String, block: StringBuilder.() -> Unit) {
    resolve("$name.kt").writeText(buildString(block))
}
