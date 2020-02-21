package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import java.util.concurrent.*
import kotlin.concurrent.*

class SingleThreadRunner(
    override val timeout: Double = AnyTdApi.DEFAULT_RECEIVE_TIMEOUT
) : SynchronizedRunner {
    override fun run(id: Long, block: () -> Boolean) {
        thread { while (block()) Unit }
    }
}

class ExecutorThreadRunner(
    private val executor: ExecutorService = Executors.newCachedThreadPool(),
    override val timeout: Double = AnyTdApi.DEFAULT_RECEIVE_TIMEOUT
) : SynchronizedRunner {
    override fun run(id: Long, block: () -> Boolean) {
        executor.execute { while (block()) Unit }
    }

    override fun cleanup() {
        executor.shutdown()
    }
}
