package dev.whyoleg.ktd.client.api.reactor

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.*
import reactor.core.publisher.*

object ReactorMapper : ResponseMapper<ReactorResponse, ReactorResponseHandler, Nothing> {
    override fun create(input: Nothing?): ReactorResponseHandler = MonoProcessor.create()
    override fun complete(handler: ReactorResponseHandler, response: TelegramResponseOrError) {
        response.map(handler::onNext, handler::onError)
    }

    override fun getResponse(handler: ReactorResponseHandler): ReactorResponse = handler
}
