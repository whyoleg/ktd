package dev.whyoleg.ktd.client

import kotlinx.atomicfu.*
import kotlin.concurrent.*

/**
 * [SynchronizedRunner] which creates new [Thread] on every [run] call
 *
 * @param timeout duration to block thread for receiving tdlib responses
 */
class DistinctThreadRunner(
    override val timeout: Double = TdApi.DEFAULT_RECEIVE_TIMEOUT
) : SynchronizedRunner {
    private val cleaned = atomic(false)
    override fun run(id: Long, block: () -> Boolean) {
        if (cleaned.value) error("Runner already cleaned up")
        thread { while (block()) Unit }
    }

    override fun cleanup() {
        cleaned.value = true
    }
}
