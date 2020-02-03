package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.client.*
import kotlinx.atomicfu.*

class DefaultTdClient(
    api: StaticTdApi,
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    updatesCallback: TdUpdatesCallback = {}
) : TdClient {
    private val client by lazy { IncrementalTdApiClient(api) }
    override val id: Long get() = client.id

    private val clientClosed = atomic(false) //todo check perf with enum(3) versus 2 bool flags
    private val clientClosing = atomic(false)

    override val isClosed: Boolean get() = clientClosed.value

    private val callbacks = ConcurrentMap<Long, TdCallback>()

    init {
        runner.run(id) {
            val response = client.receive(runner.timeout) ?: return@run true
            if (response is UpdateTdState) when (response.state) {
                is TdClosing -> clientClosing.value = true
                is TdClosed  -> clientClosed.value = true
            }
            when (response) {
                is TdUpdate          -> updatesCallback(response)
                is TdResponseOrError -> callbacks.remove(response.extra.id)?.invoke(TdResult(response))
            }

            if (clientClosed.value && callbacks.size == 0) {
                client.unsafeDestroy()
                false
            } else {
                true
            }
        }
    }

    override fun close(callback: TypedTdCallback<TdOk>?): Unit = closeWith(TdClose(), callback)
    override fun logOut(callback: TypedTdCallback<TdOk>?): Unit = closeWith(TdLogOut(), callback)
    override fun destroy(callback: TypedTdCallback<TdOk>?): Unit = closeWith(TdDestroy(), callback)

    private fun <R : TdResponse> closeWith(request: TdRequest<R>, callback: TypedTdCallback<R>? = null) {
        if (clientClosing.value) return
        if (!clientClosed.value) sendCallback(request, callback)
        clientClosing.value = true
    }

    override fun <R : TdResponse> sendCallback(request: TdRequest<R>, callback: TypedTdCallback<R>?) {
        if (clientClosing.value) callback?.invoke(TdResult(TdError(500, "Client is closing now.")))
        else client.send(request) { id ->
            callback?.let { callbacks[id] = @Suppress("UNCHECKED_CAST") (it as TdCallback) }
        }
    }

    override fun toString(): String = "TdClient($id)"
}
