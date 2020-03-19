package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*

/**
 * Abstract high-level tdlib client.
 * Can be used to create more complex clients.
 * Use [onClose] for handling closing of client.
 * Use [onUpdate] for handling updates from tdlib
 *
 * @param api api to work with tdlib
 * @param runner runner to handle tdlib responses
 */
abstract class AbstractTdClient(api: TdApi, runner: SynchronizedRunner = DefaultSynchronizedRunner()) : TdClient {
    /**
     * Underlying [DefaultTdClient] which handles all things needed to create custom client implementation
     */
    private val client by lazy { DefaultTdClient(api, runner, this::onClose, this::onUpdate) }

    /**
     * Id of tdlib client
     */
    final override val id: Long get() = client.id

    /**
     * Return true if client is closed
     */
    final override val isClosed: Boolean get() = client.isClosed

    /**
     * Gracefully close tdlib client
     *
     * @param callback callback which will be completed with [TdOk] or [TdError], if null, response is ignored
     */
    final override fun close(callback: TypedTdCallback<TdOk>?): Unit = client.close(callback)

    /**
     * Perform log out and close tdlib client.
     * Require network connection.
     * Delete all local data
     *
     * @param callback callback which will be completed with [TdOk] or [TdError], if null, response is ignored
     */
    final override fun logOut(callback: TypedTdCallback<TdOk>?): Unit = client.logOut(callback)

    /**
     * Destroy without log out and close tdlib client.
     * Delete all local data
     *
     * @param callback callback which will be completed with [TdOk] or [TdError], if null, response is ignored
     */
    final override fun destroy(callback: TypedTdCallback<TdOk>?): Unit = client.destroy(callback)

    /**
     * Send typed [TdRequest] to tdlib client.
     * Result will be returned via [TypedTdCallback]
     *
     * @param R type of [TdResponse]
     * @param request typed request to tdlib
     * @param callback callback which will be completed with [R] or [TdError], if null, response is ignored
     */
    final override fun <R : TdResponse> sendCallback(request: TdRequest<R>, callback: TypedTdCallback<R>?): Unit =
        client.sendCallback(request, callback)

    /**
     * Called after client will be closed
     */
    open fun onClose(): Unit = Unit

    /**
     * Called when [TdUpdate] received from tdlib
     *
     * @param update update from tdlib
     */
    abstract fun onUpdate(update: TdUpdate)
}
