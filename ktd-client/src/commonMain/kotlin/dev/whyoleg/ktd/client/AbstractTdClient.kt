package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

abstract class AbstractTdClient(api: TdApi, runner: SynchronizedRunner = DefaultSynchronizedRunner()) : TdClient {
    private val client by lazy { DefaultTdClient(api, runner, this::onClose, this::onUpdate) }

    final override val id: Long get() = client.id
    final override val isClosed: Boolean get() = client.isClosed

    final override fun close(callback: TypedTdCallback<TdOk>?): Unit = client.close(callback)
    final override fun logOut(callback: TypedTdCallback<TdOk>?): Unit = client.logOut(callback)
    final override fun destroy(callback: TypedTdCallback<TdOk>?): Unit = client.destroy(callback)

    final override fun <R : TdResponse> sendCallback(request: TdRequest<R>, callback: TypedTdCallback<R>?): Unit =
        client.sendCallback(request, callback)

    open fun onClose(): Unit = Unit
    abstract fun onUpdate(update: TdUpdate)
}
