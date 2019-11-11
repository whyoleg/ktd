package dev.whyoleg.ktd.generator

import dev.whyoleg.ktd.generator.builder.*
import dev.whyoleg.ktd.generator.tl.*
import dev.whyoleg.ktd.generator.tl.parser.*
import java.io.*

fun generateApi(scheme: InputStream): Map<String, String> {
    val tlData = scheme.readTlScheme().parseTlData()
    val metadata = tlData.extractMetadata()
    val tlScheme = TlScheme(tlData, metadata)
    val functionsMap = tlData.groupFunctions()
    val syncFunctions = tlData.filterIsInstance<TlFunction>().filter { TlAddition.Sync in it.metadata.additions }

    val map = mutableMapOf<String, String>()

    fun String.nested(path: String, block: String.() -> Unit) {
        ("$this/$path").block()
    }

    fun String.file(name: String, block: StringBuilder.() -> Unit) {
        val nested = "$this/$name.kt"
        map[nested] = buildString(block)
    }

    with("src/main/kotlin/dev/whyoleg/ktd/api") {
        file("Experimental") {
            buildExperimental()
        }
        file("TdApi") {
            buildApi(tlScheme)
        }
        functionsMap.forEach { (type, functions) ->
            nested(type.decapitalize()) {
                file("Raw") {
                    buildRawFunctions(type, functions)
                }
                file("Parameterized") {
                    buildFunctions(type, functions, metadata)
                }
            }
        }
        nested("sync") {
            file("Raw") {
                buildRawSyncFunctions(syncFunctions)
            }
            file("Parameterized") {
                buildSyncFunctions(syncFunctions, metadata)
            }
        }
    }

    return map
}