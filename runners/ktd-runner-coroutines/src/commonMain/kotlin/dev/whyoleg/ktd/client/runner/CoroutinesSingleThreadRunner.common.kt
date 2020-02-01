package dev.whyoleg.ktd.client.runner

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.*
import kotlinx.coroutines.*

class CoroutinesSingleThreadRunner(
    private val job: Job,
    override val timeout: Double = TelegramApi.DEFAULT_TIMEOUT
) : SynchronizedRunner {
    override fun run(block: () -> Unit) {
        launchOnSingleThread(job, "", block)
    }
}

internal expect inline fun launchOnSingleThread(job: Job, name: String, crossinline block: () -> Unit)
