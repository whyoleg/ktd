package dev.whyoleg.ktd.cli.api

import dev.whyoleg.ktd.cli.api.builder.*
import dev.whyoleg.ktd.cli.tl.*

fun apiPath(module: String, version: String, path: String): String = "api/$module/v$version/$path"

fun generateApi(scheme: ByteArray, version: String): Map<String, String> {
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

    val srcPath = "src/commonMain/kotlin/dev/whyoleg/ktd/api"

    with(apiPath("raw", version, srcPath)) {
        file("Experimental") {
            buildExperimental()
        }
        file("TdApi") {
            buildApi(tlScheme)
        }
    }
    with(apiPath("coroutines", version, srcPath)) {
        functionsMap.forEach { (type, functions) ->
            nested(type.decapitalize()) {
                functions.forEach {
                    file(it.type) {
                        buildFunction(type, it, tlScheme.metadata)
                    }
                }
            }
        }
        nested("sync") {
            syncFunctions.forEach {
                file(it.type) {
                    buildFunction("sync", it, tlScheme.metadata)
                }
            }
        }
    }

    return map
}
