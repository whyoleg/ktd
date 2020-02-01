package dev.whyoleg.ktd.client.api

interface ResponseHandlerStorage<ResponseHandler : Any> {
    operator fun set(requestId: Long, handler: ResponseHandler)
    operator fun get(responseId: Long): ResponseHandler
    fun clear()
}
