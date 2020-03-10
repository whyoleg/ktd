package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*

/**
 * Base interface which represents interaction with tdlib
 */
interface TdApi {
    /**
     * Version of tdlib
     */
    val version: String

    /**
     * Create tdlib client
     *
     * @return id of created tdlib client
     */
    fun createClient(): Long

    /**
     * Destroy tdlib client by [clientId]
     *
     * @param clientId id of tdlib client
     */
    fun destroyClient(clientId: Long)

    /**
     * Send [TdApiRequest] to client with [clientId]
     *
     * @param clientId id of tdlib client
     * @param request untyped request to tdlib
     */
    fun sendTo(clientId: Long, request: TdApiRequest)

    /**
     * Receive untyped [TdApiResponse] from client with [clientId], block thread for maximum [timeout] seconds
     *
     * @param clientId id of tdlib client
     * @param timeout maximum duration in seconds to wait for [TdApiResponse]
     *
     * @return received [TdApiResponse] or null if no [TdApiResponse] received during [timeout]
     */
    fun receiveFrom(clientId: Long, timeout: Double = DEFAULT_RECEIVE_TIMEOUT): TdApiResponse?

    /**
     * Execute [TdSyncRequest] synchronously, blocking until response received
     *
     * @param R type of [TdResponse]
     * @param request synchronous request to tdlib
     *
     * @return result represents [TdError] or typed [TdResponse]
     */
    fun <R : TdResponse> executeSynchronously(request: TdSyncRequest<R>): TdResult<R>

    companion object {
        /**
         * Default timeout for waiting response from tdlib
         */
        const val DEFAULT_RECEIVE_TIMEOUT: Double = 300.0
    }
}
