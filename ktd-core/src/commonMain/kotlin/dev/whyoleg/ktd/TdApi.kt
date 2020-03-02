package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*

interface TdApi {
    val version: String
    fun createClient(): Long
    fun destroyClient(clientId: Long)
    fun sendTo(clientId: Long, request: TdApiRequest)
    fun receiveFrom(clientId: Long, timeout: Double = DEFAULT_RECEIVE_TIMEOUT): TdApiResponse?
    fun <R : TdResponse> executeSynchronously(request: TdSyncRequest<R>): TdResult<R>

    companion object {
        const val DEFAULT_RECEIVE_TIMEOUT: Double = 300.0
    }
}
