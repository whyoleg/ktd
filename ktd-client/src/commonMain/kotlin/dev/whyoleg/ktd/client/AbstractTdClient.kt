package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

abstract class AbstractTdClient(
    api: AnyTdApi,
    runner: SynchronizedRunner = DefaultSynchronizedRunner()
) : TdClient {
    private val tdClient: DefaultTdClient by lazy { DefaultTdClient(api, runner, this::onUpdate, this::onClose) }

    final override val id: Long get() = tdClient.id
    final override val isClosed: Boolean get() = tdClient.isClosed

    final override fun close(callback: TypedTdCallback<TdOk>?): Unit = tdClient.close(callback)
    final override fun logOut(callback: TypedTdCallback<TdOk>?): Unit = tdClient.logOut(callback)
    final override fun destroy(callback: TypedTdCallback<TdOk>?): Unit = tdClient.destroy(callback)

    final override fun <R : TdResponse> sendCallback(request: TdRequest<R>, callback: TypedTdCallback<R>?): Unit =
        tdClient.sendCallback(request, callback)

    open fun onClose(): Unit = Unit
    open fun onUpdate(update: TdUpdate): Unit = Unit
}
