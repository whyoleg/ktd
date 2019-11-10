@file:Suppress("FunctionName", "unused")

import dev.whyoleg.kamp.module.*

object Modules : RootModule() {
    val client by named()
    val example by named()

    object Api : Module by named("api") {
        val generator by named()
        val stub by named()

        val apis = listOf(
            "1.5.1"
        ).map { named("v$it") }

        val latest = apis.first { it.name.contains(Versions.latestTdVersion) }
    }
}
