package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.api.*

abstract class AbstractTdClient(api: TdApi) {

    private val client = api.callbackClient(::onClose, ::onUpdate)

    val isClosed: Boolean get() = client.isClosed

    fun close() {
        client.close()
    }

    fun closeAndDestroy() {
        client.closeAndDestroy()
    }

    protected fun <R : TdResponse> sendCallback(request: TdRequest<R>, callback: TypedTdCallback<R>? = null) {
        client.send(request, callback)
    }

    protected inline fun <R : TdResponse> sendCallback(
        request: TdRequest<R>,
        crossinline onResponse: (R) -> Unit,
        crossinline onError: (TdError) -> Unit
    ): Unit = sendCallback(request) {
        when (it) {
            is TdTypedResult.Error -> onError(it.error)
            is TdTypedResult.Response -> onResponse(it.response)
        }
    }


    protected open fun onClose(): Unit = Unit

    protected abstract fun onUpdate(update: TdUpdate)
}
