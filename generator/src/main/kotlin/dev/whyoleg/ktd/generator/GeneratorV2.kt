package dev.whyoleg.ktd.generator

import dev.whyoleg.ktd.generator.builder.*
import dev.whyoleg.ktd.generator.tl.parser.*
import java.io.*

fun main() {
    val scheme = File("td/td/generate/scheme/td_api.tl")
    val lines = scheme.readTlScheme()
    val tlData = lines.parseTlData()
    buildString {
        tlData.forEach {
            it.run { write(this) }
            append("\n")
        }
    }.also(::println)
}
