package dev.whyoleg.ktd.api.client

import dev.whyoleg.ktd.api.*

class TelegramApiClient(private val api: TelegramApi) {
    private val id: Long = api.createClient()

    fun destroy(): Unit = api.destroyClient(id)
    fun send(request: TelegramApiRequest): Unit = api.sendTo(id, request)
    fun receive(timeout: Double = TelegramApi.DEFAULT_TIMEOUT): TelegramApiResponse? = api.receiveFrom(id, timeout)
}
