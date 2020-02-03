package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import kotlinx.coroutines.*

class CoroutinesSingleThreadRunner(
    private val job: Job,
    override val timeout: Double = StaticTdApi.DEFAULT_RECEIVE_TIMEOUT
) : SynchronizedRunner {
    override fun run(id: Long, block: () -> Boolean) {
        launchOnSingleThread(job, "", block)
    }
}

internal expect inline fun launchOnSingleThread(job: Job, name: String, crossinline block: () -> Boolean)
