package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*

interface SynchronizedRunner {
    val timeout: Double get() = StaticTdApi.DEFAULT_RECEIVE_TIMEOUT
    fun run(id: Long, onClose: () -> Unit, block: () -> Boolean)
}
