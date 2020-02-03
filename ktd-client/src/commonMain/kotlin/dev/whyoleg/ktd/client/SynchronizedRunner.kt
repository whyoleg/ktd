package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*

interface SynchronizedRunner {
    val timeout: Double get() = StaticTdApi.DEFAULT_RECEIVE_TIMEOUT
    fun run(id: Long, block: () -> Boolean)
}
