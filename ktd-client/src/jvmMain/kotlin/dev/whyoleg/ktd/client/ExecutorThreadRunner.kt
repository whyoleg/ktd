package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import java.util.concurrent.*

class SingleThreadRunner(
    override val timeout: Double = StaticTdApi.DEFAULT_RECEIVE_TIMEOUT
) : ExecutorThreadRunner(Executors.newSingleThreadExecutor())

class CachedThreadRunner(
    threadFactory: ThreadFactory = Executors.defaultThreadFactory(),
    override val timeout: Double = StaticTdApi.DEFAULT_RECEIVE_TIMEOUT
) : ExecutorThreadRunner(Executors.newCachedThreadPool(threadFactory)) {
    companion object : ExecutorThreadRunner(Executors.newCachedThreadPool())
}

abstract class ExecutorThreadRunner(private val executor: ExecutorService) : SynchronizedRunner {
    final override fun run(id: Long, onClose: () -> Unit, block: () -> Boolean) {
        executor.execute {
            try {
                do Unit while (block())
            } finally {
                onClose()
            }
        }
    }

    fun shutdown() {
        executor.shutdown()
    }
}
