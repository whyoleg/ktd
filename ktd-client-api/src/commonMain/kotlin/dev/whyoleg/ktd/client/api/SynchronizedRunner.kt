package dev.whyoleg.ktd.client.api

import dev.whyoleg.ktd.api.*

interface SynchronizedRunner {
    val timeout: Double get() = TelegramApi.DEFAULT_TIMEOUT
    fun run(block: () -> Unit)
}
