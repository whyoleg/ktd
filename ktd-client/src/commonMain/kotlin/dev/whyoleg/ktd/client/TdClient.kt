package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*

/**
 * Base high-level tdlib client.
 * Can be used to create more complex clients, or for direct interaction with tdlib
 */
interface TdClient {

    /**
     * Id of tdlib client
     */
    val id: Long

    /**
     * Return true if client is closed
     */
    val isClosed: Boolean

    /**
     * Gracefully close tdlib client
     *
     * @param callback callback which will be completed with [TdOk] or [TdError], if null, response is ignored
     */
    fun close(callback: TypedTdCallback<TdOk>? = null)

    /**
     * Perform log out and close tdlib client.
     * Require network connection.
     * Delete all local data
     *
     * @param callback callback which will be completed with [TdOk] or [TdError], if null, response is ignored
     */
    fun logOut(callback: TypedTdCallback<TdOk>? = null)

    /**
     * Destroy without log out and close tdlib client.
     * Delete all local data
     *
     * @param callback callback which will be completed with [TdOk] or [TdError], if null, response is ignored
     */
    fun destroy(callback: TypedTdCallback<TdOk>? = null)

    /**
     * Send typed [TdRequest] to tdlib client.
     * Result will be returned via [TypedTdCallback]
     *
     * @param R type of [TdResponse]
     * @param request typed request to tdlib
     * @param callback callback which will be completed with [R] or [TdError], if null, response is ignored
     */
    fun <R : TdResponse> sendCallback(request: TdRequest<R>, callback: TypedTdCallback<R>? = null)
}

/**
 * Send typed [TdRequest] to tdlib client.
 * Result will be returned via [onResponse] or [onError]
 *
 * @param R type of [TdResponse]
 * @param request typed request to tdlib
 * @param onResponse callback called when successful response of type [R] received
 * @param onError callback called when [TdError] received
 */
inline fun <R : TdResponse> TdClient.sendCallback(
    request: TdRequest<R>,
    crossinline onResponse: (R) -> Unit,
    crossinline onError: (TdError) -> Unit
): Unit = sendCallback(request) { handle(onResponse, onError) }
