package dev.whyoleg.ktd.api.client

import dev.whyoleg.ktd.api.*

class TdApiClient(private val api: StaticTdApi) {
    val id: Long by lazy { api.createClient() }

    fun unsafeDestroy(): Unit = api.destroyClient(id)
    fun send(request: TdApiRequest): Unit = api.sendTo(id, request)
    fun receive(timeout: Double = StaticTdApi.DEFAULT_RECEIVE_TIMEOUT): TdApiResponse? = api.receiveFrom(id, timeout)
}
