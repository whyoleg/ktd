package dev.whyoleg.ktd.client.api

import kotlin.concurrent.*

object SingleThreadRunner : SynchronizedRunner {
    override fun run(block: () -> Unit) {
        thread { while (true) block() }
    }
}
