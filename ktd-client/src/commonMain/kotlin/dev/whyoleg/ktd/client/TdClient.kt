package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*

interface TdClient {
    val id: Long
    val isClosed: Boolean

    fun close(callback: TypedTdCallback<TdOk>? = null)
    fun logOut(callback: TypedTdCallback<TdOk>? = null)
    fun destroy(callback: TypedTdCallback<TdOk>? = null)

    fun <R : TdResponse> sendCallback(request: TdRequest<R>, callback: TypedTdCallback<R>? = null)
}

inline fun <R : TdResponse> TdClient.sendCallback(
    request: TdRequest<R>,
    crossinline onResponse: (R) -> Unit,
    crossinline onError: (TdError) -> Unit
): Unit = sendCallback(request) { handle(onResponse, onError) }
