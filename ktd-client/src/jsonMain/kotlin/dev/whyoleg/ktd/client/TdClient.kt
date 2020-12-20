package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.json.*
import kotlinx.atomicfu.*
import kotlinx.atomicfu.locks.*

actual class TdClient internal constructor(
    private val serializer: TdJsonSerializer,
    threadSafe: Boolean = true
) {
    private val id = TdJson.create()
    private val requestId = atomic(0L)

    private val receiveLock = if (threadSafe) reentrantLock() else null

    private inline fun <R> locked(block: () -> R): R = when (receiveLock) {
        null -> block()
        else -> receiveLock.withLock(block)
    }

    @PublishedApi
    internal fun nextRequestId() = requestId.incrementAndGet()

    actual inline fun send(request: (requestId: Long) -> TdApiRequest): Long {
        val requestId = nextRequestId()
        send(requestId, request(requestId))
        return requestId
    }

    @PublishedApi
    internal fun send(requestId: Long, request: TdApiRequest) {
        TdJson.send(id, serializer.request(requestId, request))
    }

    actual fun receive(timeout: Double): TdResult? = locked { TdJson.receive(id, timeout)?.let(serializer::result) }

    actual fun close() {
        TdJson.send(id, """{"@type": "close"}""")
    }

    actual fun closeAndDestroy() {
        TdJson.send(id, """{"@type": "destroy"}""")
    }

    actual fun clean(): Unit = locked { TdJson.destroy(id) }

}
