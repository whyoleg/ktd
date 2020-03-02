package dev.whyoleg.ktd.internal

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.json.*
import kotlinx.serialization.modules.*

@UseExperimental(ExperimentalTdInterface::class)
class JsonTdApi
@Deprecated(message = "Constructor used internally in api modules to setup serialization for api.", level = DeprecationLevel.ERROR)
constructor(override val version: String, private val lazySerialModule: Lazy<SerialModule>) : TdApi {
    private val tdJson by lazy { TdJson.also { TdJson.init() } }
    private val serializer by lazy { TdJsonSerializer(lazySerialModule.value) }

    override fun createClient(): Long = tdJson.create()

    override fun destroyClient(clientId: Long): Unit = tdJson.destroy(clientId)

    override fun sendTo(clientId: Long, request: TdApiRequest): Unit = tdJson.send(clientId, serializer.stringify(request))

    override fun receiveFrom(clientId: Long, timeout: Double): TdApiResponse? = tdJson.receive(clientId, timeout)?.let(serializer::parse)

    override fun <R : TdResponse> executeSynchronously(request: TdSyncRequest<R>): TdResult<R> =
        TdResult(tdJson.execute(serializer.stringify(request)).let(serializer::parse) as TdResponseOrError)
}
