package dev.whyoleg.ktd.client

import kotlin.concurrent.*

object SingleThreadRunner : SynchronizedRunner {
    override fun run(id: Long, block: () -> Boolean) {
        thread { do Unit while (block()) }
    }
}
