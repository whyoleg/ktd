package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import kotlinx.atomicfu.*

/**
 * Create default high-level tdlib client.
 *
 * @receiver api to work with tdlib
 *
 * @param runner runner to handle tdlib responses
 * @param onClose callback called after client will be closed
 * @param updatesCallback callback called when [TdUpdate] received from tdlib
 *
 * @return [TdClient] default implementation
 */
fun TdApi.defaultTdClient(
    runner: SynchronizedRunner = DefaultSynchronizedRunner(),
    onClose: () -> Unit = {},
    updatesCallback: TdUpdatesCallback = {}
): TdClient = DefaultTdClient(this, runner, onClose, updatesCallback)

/**
 * Default high-level tdlib client.
 * Used by default in [TdApi.defaultTdClient]
 *
 * @param api api to work with tdlib
 * @param runner runner to handle tdlib responses
 * @param onClose callback called after client will be closed
 * @param updatesCallback callback called when [TdUpdate] received from tdlib
 */
internal class DefaultTdClient(
    api: TdApi,
    runner: SynchronizedRunner,
    onClose: () -> Unit,
    updatesCallback: TdUpdatesCallback
) : TdClient {

    /**
     * Contains true after client is in closing state
     */
    private val clientClosing = atomic(false)

    /**
     * Contains true after client is in closed state
     */
    private val clientClosed = atomic(false)

    /**
     * Return true if client is closed
     */
    override val isClosed: Boolean get() = clientClosed.value

    /**
     * Map which contains callbacks for responses
     */
    private val callbacks = ConcurrentMap<Long, TdCallback>()

    /**
     * Underlying [IncrementalTdApiClient] which handles tdlib responses
     */
    private val client by lazy {
        val client = IncrementalTdApiClient(api)
        runner.run(client.id) {
            try {
                when (val response = client.unsafeReceive(runner.timeout)) {
                    null                 -> Unit
                    is TdUpdate          -> {
                        response.runCatching(updatesCallback)
                        if (response is TdUpdateState) when (response.state) {
                            is TdClosing -> clientClosing.value = true
                            is TdClosed  -> clientClosed.value = true
                        }
                    }
                    is TdResponseOrError -> callbacks.remove(response.extra.id)?.runCatching { this(TdResult(response)) }
                }
            } catch (ignore: Throwable) {
            }
            val finish = clientClosed.value && callbacks.isEmpty()
            if (finish) {
                runCatching(client::unsafeDestroy)
                runCatching(onClose)
            }
            !finish
        }
        client
    }

    /**
     * Id of tdlib client
     */
    override val id: Long get() = client.id

    /**
     * Gracefully close tdlib client
     *
     * @param callback callback which will be completed with [TdOk] or [TdError], if null, response is ignored
     */
    override fun close(callback: TypedTdCallback<TdOk>?): Unit = closeWith(TdClose(), callback)

    /**
     * Perform log out and close tdlib client.
     * Require network connection.
     * Delete all local data
     *
     * @param callback callback which will be completed with [TdOk] or [TdError], if null, response is ignored
     */
    override fun logOut(callback: TypedTdCallback<TdOk>?): Unit = closeWith(TdLogOut(), callback)

    /**
     * Destroy without log out and close tdlib client.
     * Delete all local data
     *
     * @param callback callback which will be completed with [TdOk] or [TdError], if null, response is ignored
     */
    override fun destroy(callback: TypedTdCallback<TdOk>?): Unit = closeWith(TdDestroy(), callback)

    /**
     * Close tdlib client and set [clientClosing] to true
     *
     * @param callback callback which will be completed with [TdOk] or [TdError], if null, response is ignored
     */
    private fun closeWith(request: TdRequest<TdOk>, callback: TypedTdCallback<TdOk>? = null) {
        sendCallback(request, callback)
        clientClosing.value = true
    }

    /**
     * Send typed [TdRequest] to tdlib client.
     * Result will be returned via [TypedTdCallback].
     * If client is in closing state - returns [TdError] with code 500
     *
     * @param R type of [TdResponse]
     * @param request typed request to tdlib
     * @param callback callback which will be completed with [R] or [TdError], if null, response is ignored
     */
    override fun <R : TdResponse> sendCallback(request: TdRequest<R>, callback: TypedTdCallback<R>?) {
        when (clientClosing.value) {
            true  -> callback?.invoke(TdResult(TdError(500, "Client is closing now.")))
            false -> client.send(request) { requestId ->
                callback?.let { callbacks[requestId] = @Suppress("UNCHECKED_CAST") (it as TdCallback) }
            }
        }
    }

    override fun toString(): String = "TdClient($id)"
}
