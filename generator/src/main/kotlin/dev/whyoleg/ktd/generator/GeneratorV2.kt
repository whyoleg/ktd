package dev.whyoleg.ktd.generator

import dev.whyoleg.ktd.generator.builder.*
import dev.whyoleg.ktd.generator.tl.parser.*
import java.io.*

fun main() {
    val schemeFile = File("td/td/generate/scheme/td_api.tl")
    val outputDir = File("library/src/main/kotlin/dev/whyoleg/ktd/api")
    val tlData = schemeFile.readTlScheme().parseTlData()
    with(outputDir) {
        mkdirs()
        file("TdApi.kt") {
            buildApi(tlData)
        }
        file("Experimental.kt") {
            buildExperimental()
        }
    }
}

fun File.file(name: String, block: StringBuilder.() -> Unit) {
    resolve(name).writeText(buildString(block))
}
