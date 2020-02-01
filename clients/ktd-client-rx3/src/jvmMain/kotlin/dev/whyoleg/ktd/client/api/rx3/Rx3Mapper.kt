package dev.whyoleg.ktd.client.api.rx3

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.*
import io.reactivex.rxjava3.subjects.*

object Rx3Mapper : ResponseMapper<Rx3Response, Rx3ResponseHandler, Nothing> {
    override fun create(input: Nothing?): Rx3ResponseHandler = SingleSubject.create()
    override fun complete(handler: Rx3ResponseHandler, response: TelegramResponseOrError) {
        response.map(handler::onSuccess, handler::onError)
    }

    override fun getResponse(handler: Rx3ResponseHandler): Rx3Response = handler
}
