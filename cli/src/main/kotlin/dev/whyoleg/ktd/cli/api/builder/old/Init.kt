package dev.whyoleg.ktd.cli.api.builder.old

import dev.whyoleg.ktd.cli.tl.*
import java.io.*

fun main() {
    val version = "1.6.0"
    val tdBytes = File("td/td/telegram/Td.cpp").readBytes()
    val tlBytes = File("td/td/generate/scheme/td_api.tl").readBytes()


    val data = parseData(tdBytes, tlBytes)
    data.forEach { (kind, scheme) ->
        if (kind != TlKind.Test) return@forEach
        //        if (kind == TlKind.BuiltIn || kind == TlKind.Test) return@forEach
        File("ktd-api-${kind.name.toLowerCase()}/src/commonMain/kotlin").deleteRecursively()

        tdApiFile(version, kind)
        tdApiClasses(scheme, kind)
        builderFile(scheme, kind)
    }
}
