package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import java.util.concurrent.*
import kotlin.concurrent.*

class SingleThreadRunner(
    override val timeout: Double = AnyTdApi.DEFAULT_RECEIVE_TIMEOUT
) : SynchronizedRunner {
    override fun run(id: Long, onClose: () -> Unit, block: () -> Boolean) {
        thread {
            try {
                while (block()) Unit
                do Unit while (block())
            } finally {
                onClose()
            }
        }
    }
}

@Suppress("FunctionName")
fun CachedThreadRunner(
    threadFactory: ThreadFactory = Executors.defaultThreadFactory(),
    timeout: Double = AnyTdApi.DEFAULT_RECEIVE_TIMEOUT
): SynchronizedRunner = ExecutorThreadRunner(Executors.newCachedThreadPool(threadFactory), timeout)

class ExecutorThreadRunner(
    private val executor: ExecutorService,
    override val timeout: Double = AnyTdApi.DEFAULT_RECEIVE_TIMEOUT
) : SynchronizedRunner {
    override fun run(id: Long, onClose: () -> Unit, block: () -> Boolean) {
        executor.execute {
            try {
                while (block()) Unit
            } finally {
                onClose()
            }
        }
    }

    override fun cleanup() {
        executor.shutdown()
    }
}
