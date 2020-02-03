package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*

abstract class AbstractTdClient(
    api: StaticTdApi,
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    updatesCallback: TdUpdatesCallback = {}
) : TdClient {
    private val tdClient: TdClient by lazy { DefaultTdClient(api, runner, updatesCallback) }

    override val id: Long get() = tdClient.id
    override val isClosed: Boolean get() = tdClient.isClosed

    override fun close(callback: TypedTdCallback<TdOk>?): Unit = tdClient.close(callback)
    override fun logOut(callback: TypedTdCallback<TdOk>?): Unit = tdClient.logOut(callback)
    override fun destroy(callback: TypedTdCallback<TdOk>?): Unit = tdClient.destroy(callback)

    override fun <R : TdResponse> sendCallback(request: TdRequest<R>, callback: TypedTdCallback<R>?): Unit =
        tdClient.sendCallback(request, callback)
}
