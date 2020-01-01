package dev.whyoleg.ktd.cli.api

import dev.whyoleg.ktd.cli.api.builder.*
import dev.whyoleg.ktd.cli.api.tl.*
import dev.whyoleg.ktd.cli.api.tl.parser.*

fun ByteArray.parseScheme(): TlScheme {
    val tlData = readTlScheme().parseTlData()
    val metadata = tlData.extractMetadata()
    return TlScheme(tlData, metadata)
}

fun generateApi(scheme: ByteArray): Map<String, String> {
    val tlScheme = scheme.parseScheme()
    val functionsMap = tlScheme.data.groupFunctions()
    val syncFunctions = tlScheme.data.filterIsInstance<TlFunction>().filter { TlAddition.Sync in it.metadata.additions }

    val map = mutableMapOf<String, String>()

    fun String.nested(path: String, block: String.() -> Unit) {
        ("$this/$path").block()
    }

    fun String.file(name: String, block: StringBuilder.() -> Unit) {
        val nested = "$this/$name.kt"
        map[nested] = buildString(block)
    }

    val srcPath = "src/main/kotlin/dev/whyoleg/ktd/api"
    with("raw/$srcPath") {
        file("Experimental") {
            buildExperimental()
        }
        file("TdApi") {
            buildApi(tlScheme)
        }
    }
    with("coroutines/$srcPath") {
        functionsMap.forEach { (type, functions) ->
            nested(type.decapitalize()) {
                file("Raw") {
                    buildRawFunctions(type, functions)
                }
                file("Parameterized") {
                    buildFunctions(type, functions, tlScheme.metadata)
                }
            }
        }
        nested("sync") {
            file("Raw") {
                buildRawSyncFunctions(syncFunctions)
            }
            file("Parameterized") {
                buildSyncFunctions(syncFunctions, tlScheme.metadata)
            }
        }
    }

    return map
}
