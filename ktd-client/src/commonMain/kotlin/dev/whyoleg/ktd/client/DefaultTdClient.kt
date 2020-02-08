package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.*

class DefaultTdClient(
    api: StaticTdApi,
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    updatesCallback: TdUpdatesCallback = {},
    onClose: () -> Unit = {}
) : TdClient {
    private val clientClosing = atomic(false)
    private val clientClosed = atomic(false)

    override val isClosed: Boolean get() = clientClosed.value

    private val callbacks = ConcurrentMap<Long, TdCallback>()

    private val client by lazy {
        val client = IncrementalTdApiClient(api)
        runner.run(client.id, {
            runCatching(client::unsafeDestroy)
            runCatching(onClose)
        }) {
            when (val response = client.receive(runner.timeout)) {
                null                 -> Unit
                is TdUpdate          -> {
                    response.runCatching(updatesCallback)
                    if (response is TdStateUpdated) when (response.state) {
                        is TdClosing -> clientClosing.value = true
                        is TdClosed  -> clientClosed.value = true
                    }
                }
                is TdResponseOrError -> callbacks.remove(response.extra.id)?.runCatching { this(TdResult(response)) }
            }
            !clientClosed.value || !callbacks.isEmpty()
        }
        client
    }
    override val id: Long get() = client.id

    override fun close(callback: TypedTdCallback<TdOk>?): Unit = closeWith(TdClose(), callback)
    override fun logOut(callback: TypedTdCallback<TdOk>?): Unit = closeWith(TdLogOut(), callback)
    override fun destroy(callback: TypedTdCallback<TdOk>?): Unit = closeWith(TdDestroy(), callback)

    private fun <R : TdResponse> closeWith(request: TdRequest<R>, callback: TypedTdCallback<R>? = null) {
        sendCallback(request, callback)
        clientClosing.value = true
    }

    override fun <R : TdResponse> sendCallback(request: TdRequest<R>, callback: TypedTdCallback<R>?) {
        if (clientClosing.value) callback?.invoke(TdResult(TdError(500, "Client is closing now.")))
        else client.send(request) { requestId ->
            callback?.let { callbacks[requestId] = @Suppress("UNCHECKED_CAST") (it as TdCallback) }
        }
    }

    override fun toString(): String = "TdClient($id)"
}
