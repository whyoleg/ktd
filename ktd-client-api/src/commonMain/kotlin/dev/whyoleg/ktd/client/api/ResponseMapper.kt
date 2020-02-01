package dev.whyoleg.ktd.client.api

import dev.whyoleg.ktd.api.*

interface ResponseMapper<Response, ResponseHandler : Any, ResponseHandlerInput : Any> {
    fun create(input: ResponseHandlerInput? = null): ResponseHandler
    fun complete(handler: ResponseHandler, response: TelegramResponseOrError)
    fun getResponse(handler: ResponseHandler): Response
}
