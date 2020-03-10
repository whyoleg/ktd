package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import java.util.concurrent.*

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
