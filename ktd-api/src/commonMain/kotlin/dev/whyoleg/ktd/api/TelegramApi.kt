package dev.whyoleg.ktd.api

import dev.whyoleg.ktd.api.internal.*
import dev.whyoleg.ktd.json.*

class TelegramApi internal constructor(val version: String, private val serializer: TelegramJsonSerializer) {

    fun createClient(): Long =
        TelegramJson.create()

    fun destroyClient(clientId: Long): Unit =
        TelegramJson.destroy(clientId)

    fun sendTo(clientId: Long, request: TelegramApiRequest): Unit =
        TelegramJson.send(clientId, serializer.stringify(request))

    fun receiveFrom(clientId: Long, timeout: Double = DEFAULT_TIMEOUT): TelegramApiResponse? =
        TelegramJson.receive(clientId, timeout)?.let(serializer::parse)

    fun <R : TelegramResponse> executeSynchronously(request: SyncTelegramRequest<R>): R =
        TelegramJson.execute(serializer.stringify(request)).let(serializer::parse).map(
            { @Suppress("UNCHECKED_CAST") (it as R) },
            { throw it },
            { error("") }
        )

    companion object {
        const val DEFAULT_TIMEOUT: Double = 10.0
    }
}
