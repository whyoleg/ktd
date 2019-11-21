@file:Suppress("FunctionName", "unused")

import dev.whyoleg.kamp.module.*

object Modules : RootModule() {

    object Client : Module by named("client") {
        val raw = named("raw", "client/raw")
        val coroutines = named("coroutines", "client/coroutines")
    }

    object Api : Module by named("api") {
        val stub by named()
        private val apis = Versions.td.associateWith { ApiModule(it, this) }
        val latest = apis[Versions.tdLatest] ?: error("Wrong latest td version")
        operator fun get(version: String): ApiModule = apis[version] ?: error("Wrong td version")
    }

    val generator by named()
    val example by named()
}

class ApiModule(version: String, rootModule: Module) : Module by rootModule.named("v$version") {
    val raw by named()
    val coroutines by named()
    val lib by named()
}