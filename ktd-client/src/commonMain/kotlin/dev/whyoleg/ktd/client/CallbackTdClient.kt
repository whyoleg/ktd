package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.*

fun TdApi.callbackClient(
    onClose: () -> Unit = {},
    updatesCallback: TdUpdatesCallback
): CallbackTdClient = CallbackTdClient(client(threadSafe = false), onClose, updatesCallback)

class CallbackTdClient internal constructor(
    private val client: TdClient,
    onClose: () -> Unit,
    updatesCallback: TdUpdatesCallback
) {

    private val clientClosing = atomic(false)
    private val clientClosed = atomic(false)

    private val callbacks = concurrentMap<Long, TdCallback>()

    val isClosed: Boolean get() = clientClosed.value

    init {
        runInThread {
            when (val response = client.receive()) {
                null -> Unit
                is TdResult.Update -> {
                    val update = response.update
                    if (update is TdUpdateState) when (update.state) {
                        is TdClosing -> clientClosing.value = true
                        is TdClosed -> clientClosed.value = true
                    }
                    update.runCatching(updatesCallback)
                }
                is TdResult.ResponseOrError -> callbacks.remove(response.id)?.runCatching { this(response.typed()) }
            }
            val finish = clientClosed.value && callbacks.isEmpty()
            if (finish) {
                runCatching(client::clean)
                runCatching(onClose)
            }
            !finish
        }
    }

    fun close() {
        clientClosing.value = true
        client.close()
    }

    fun closeAndDestroy() {
        clientClosing.value = true
        client.closeAndDestroy()
    }

    fun <R : TdResponse> send(request: TdRequest<R>, callback: TypedTdCallback<R>? = null) {
        when (clientClosing.value) {
            true -> callback?.invoke(TdTypedResult.Error(TdError(500, "Client is closing now")))
            false -> when (callback) {
                null -> client.send(request)
                else -> client.send { requestId ->
                    callbacks[requestId] = @Suppress("UNCHECKED_CAST") (callback as TdCallback)
                    request
                }
            }
        }
    }
}

inline fun <R : TdResponse> CallbackTdClient.send(
    request: TdRequest<R>,
    crossinline onResponse: (R) -> Unit,
    crossinline onError: (TdError) -> Unit
): Unit = send(request) {
    when (it) {
        is TdTypedResult.Error -> onError(it.error)
        is TdTypedResult.Response -> onResponse(it.response)
    }
}
