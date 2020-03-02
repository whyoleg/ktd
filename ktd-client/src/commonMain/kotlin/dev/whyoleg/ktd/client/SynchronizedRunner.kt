package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*

interface SynchronizedRunner {
    val timeout: Double get() = TdApi.DEFAULT_RECEIVE_TIMEOUT
    fun run(id: Long, block: () -> Boolean)
    fun cleanup(): Unit = Unit
}
