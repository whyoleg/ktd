package dev.whyoleg.ktd.test

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.*

class TestTdApi<T : TestTdInstance>(private val instanceFactory: () -> T) : TdApi {
    override val version: String = "test"

    private val idCounter = atomic(0L)
    private val map = mutableMapOf<Long, T>()

    val activeClients: Int get() = map.size
    fun instance(id: Long): T = map.getValue(id)
    fun instanceOrNull(id: Long): T? = map[id]

    override fun createClient(): Long {
        val id = idCounter.incrementAndGet()
        map[id] = instanceFactory()
        return id
    }

    override fun destroyClient(clientId: Long) {
        map -= clientId
    }

    override fun sendTo(clientId: Long, request: TdApiRequest) {
        map.getValue(clientId).send(request)
    }

    override fun receiveFrom(clientId: Long, timeout: Double): TdApiResponse? {
        return map.getValue(clientId).receive(timeout)
    }

    override fun <R : TdResponse> executeSynchronously(request: TdSyncRequest<R>): TdResult<R> = error("")
}
