package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.internal.*
import dev.whyoleg.ktd.json.*
import kotlinx.serialization.modules.*

open class AnyTdApi
@Deprecated(message = "Constructor used internally in api modules to setup serialization for api.", level = DeprecationLevel.ERROR)
constructor(val version: String, private val lazySerialModule: Lazy<SerialModule>) {

    private val serializer by lazy { TdJsonSerializer(lazySerialModule.value) }

    fun createClient(): Long =
        tdJson.create()

    fun destroyClient(clientId: Long): Unit =
        tdJson.destroy(clientId)

    fun sendTo(clientId: Long, request: TdApiRequest): Unit =
        tdJson.send(clientId, serializer.stringify(request))

    fun receiveFrom(clientId: Long, timeout: Double = DEFAULT_RECEIVE_TIMEOUT): TdApiResponse? =
        tdJson.receive(clientId, timeout)?.let(serializer::parse)

    fun <R : TdResponse> executeSynchronously(request: TdSyncRequest<R>): TdResult<R> =
        TdResult(tdJson.execute(serializer.stringify(request)).let(serializer::parse) as TdResponseOrError)

    companion object {
        private val tdJson by lazy { TdJson.apply { init() } }
        const val DEFAULT_RECEIVE_TIMEOUT: Double = 300.0
    }
}
