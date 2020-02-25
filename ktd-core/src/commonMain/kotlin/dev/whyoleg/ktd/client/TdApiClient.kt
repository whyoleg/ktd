package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

class TdApiClient(private val api: AnyTdApi) {
    val id: Long by lazy { api.createClient() }

    fun unsafeDestroy(): Unit = api.destroyClient(id)
    fun send(request: TdApiRequest): Unit = api.sendTo(id, request)
    fun receive(timeout: Double = AnyTdApi.DEFAULT_RECEIVE_TIMEOUT): TdApiResponse? = api.receiveFrom(id, timeout)
}
