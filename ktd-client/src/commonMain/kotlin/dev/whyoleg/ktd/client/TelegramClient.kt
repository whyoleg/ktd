package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.client.*
import dev.whyoleg.ktd.client.api.*

open class TelegramClient<Response, ResponseHandler : Any, ResponseHandlerInput : Any, Updates : Any>(
    api: TelegramApi,
    private val manager: ClientManager<Response, ResponseHandler, ResponseHandlerInput, Updates>
) {
    private val client = IncrementalTelegramApiClient(api)

    val updates: Updates get() = manager.updates

    fun destroy(): Unit = client.destroy()

    init {
        manager.consume(client::receive)
    }

    fun sendIgnored(request: TelegramApiRequest) {
        client.send(request)
    }

    fun sendUntyped(request: TelegramApiRequest, input: ResponseHandlerInput? = null): Response =
        client.sendReturned(request) { manager.save(it, input) }.let(manager::getResponse)
}
