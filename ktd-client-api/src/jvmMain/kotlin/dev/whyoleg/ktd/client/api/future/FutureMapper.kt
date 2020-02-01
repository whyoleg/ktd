package dev.whyoleg.ktd.client.api.future

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.*
import java.util.concurrent.*

object FutureMapper : ResponseMapper<FutureResponse, FutureResponseHandler, Nothing> {
    override fun create(input: Nothing?): FutureResponseHandler = CompletableFuture()
    override fun complete(handler: FutureResponseHandler, response: TelegramResponseOrError) {
        response.map(handler::complete, handler::completeExceptionally)
    }

    override fun getResponse(handler: FutureResponseHandler): FutureResponse = handler
}
