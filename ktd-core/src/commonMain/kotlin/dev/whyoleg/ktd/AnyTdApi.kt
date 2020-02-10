package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.internal.*
import dev.whyoleg.ktd.json.*
import kotlinx.serialization.modules.*

abstract class AnyTdApi
@Deprecated(message = "Constructor used internally to setup serialization for api.", level = DeprecationLevel.ERROR)
constructor(val version: String, moduleBuilder: SerializersModuleBuilder.() -> Unit) {

    private val tdJson by lazy { TdJson.apply { init() } }

    private val serializer by lazy { TdJsonSerializer(moduleBuilder) }

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
        const val DEFAULT_RECEIVE_TIMEOUT: Double = 300.0
    }
}
