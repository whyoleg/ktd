package dev.whyoleg.ktd.client.api.rx2

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.*
import io.reactivex.subjects.*

object Rx2Mapper : ResponseMapper<Rx2Response, Rx2ResponseHandler, Nothing> {
    override fun create(input: Nothing?): Rx2ResponseHandler = SingleSubject.create()
    override fun complete(handler: Rx2ResponseHandler, response: TelegramResponseOrError) {
        response.map(handler::onSuccess, handler::onError)
    }

    override fun getResponse(handler: Rx2ResponseHandler): Rx2Response = handler
}
