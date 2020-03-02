package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import kotlinx.atomicfu.*
import kotlin.concurrent.*

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