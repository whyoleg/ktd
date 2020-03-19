package dev.whyoleg.ktd.client

import java.util.concurrent.*

/**
 * [SynchronizedRunner] which use [ExecutorService] to execute [run] block.
 *
 * @param executor executor to schedule [run] blocks for execution
 * @param timeout duration to block thread for receiving tdlib responses
 */
class ExecutorThreadRunner(
    private val executor: ExecutorService = Executors.newCachedThreadPool(),
    override val timeout: Double = TdApi.DEFAULT_RECEIVE_TIMEOUT
) : SynchronizedRunner {
    override fun run(id: Long, block: () -> Boolean) {
        executor.execute { while (block()) Unit }
    }

    override fun cleanup() {
        executor.shutdown()
    }
}
