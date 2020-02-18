package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*

interface SynchronizedRunner {
    val timeout: Double get() = AnyTdApi.DEFAULT_RECEIVE_TIMEOUT
    fun run(id: Long, onClose: () -> Unit, block: () -> Boolean)
    fun cleanup(): Unit = Unit
}
