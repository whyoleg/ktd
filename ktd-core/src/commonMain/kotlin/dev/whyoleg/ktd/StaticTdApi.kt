package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.internal.*
import dev.whyoleg.ktd.json.*

@Deprecated(
    "Name will be changed to TdApi in 0.6.1, after migration to new api schema. " +
            "Affects only custom clients, not used in general code"
)
class StaticTdApi internal constructor(val version: String, private val serializer: TdJsonSerializer) {

    fun createClient(): Long =
        TdJson.create()

    fun destroyClient(clientId: Long): Unit =
        TdJson.destroy(clientId)

    fun sendTo(clientId: Long, request: TdApiRequest): Unit =
        TdJson.send(clientId, serializer.stringify(request))

    fun receiveFrom(clientId: Long, timeout: Double = DEFAULT_RECEIVE_TIMEOUT): TdApiResponse? =
        TdJson.receive(clientId, timeout)?.let(serializer::parse)

    fun <R : TdResponse> executeSynchronously(request: TdSyncRequest<R>): TdResult<R> =
        TdResult(TdJson.execute(serializer.stringify(request)).let(serializer::parse) as TdResponseOrError)

    companion object {
        const val DEFAULT_RECEIVE_TIMEOUT: Double = 300.0
    }
}
