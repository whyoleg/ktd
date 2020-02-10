package dev.whyoleg.ktd.cli.api.builder.old

import dev.whyoleg.ktd.cli.tl.*
import java.io.*

fun main() {
    val scheme = File("td/td/generate/scheme/td_api.tl").readBytes().parseScheme()
    oldApiFile(scheme.metadata)
    newApi(scheme.metadata)
    builderFile(scheme.metadata)
}
