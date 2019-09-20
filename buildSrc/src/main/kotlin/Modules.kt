@file:Suppress("FunctionName", "unused")

import dev.whyoleg.kamp.module.*

object Modules : RootModule() {
    val generator by named()
    val library by named()
    val example by named()
}