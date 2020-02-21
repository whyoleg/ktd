package dev.whyoleg.ktd.cli.api.generator

import dev.whyoleg.ktd.cli.tl.*
import java.io.*

fun main() {
    val version = "1.6.0"
    val tdBytes = File("td/td/telegram/Td.cpp").readBytes()
    val tlBytes = File("td/td/generate/scheme/td_api.tl").readBytes()


    val data = parseData(tdBytes, tlBytes)
    //        data.forEach { (kind, scheme) ->
    //            if (kind == TlKind.Ignore) return@forEach
    //            File("api/ktd-api-${kind.name.toLowerCase()}/src/commonMain/kotlin").deleteRecursively()
    //            File("api-suspend/ktd-api-${kind.name.toLowerCase()}-suspend/src/commonMain/kotlin").deleteRecursively()
    //
    //            tdApiFile(version, kind)
    //            tdApiClasses(scheme, kind)
    //            builderFile(scheme, kind)
    //            suspendTdApiFunctions(scheme, kind)
    //        }
    oldApiFile(data.getValue(TlKind.Core).copy(data = data.flatMap { it.value.data }))
}
