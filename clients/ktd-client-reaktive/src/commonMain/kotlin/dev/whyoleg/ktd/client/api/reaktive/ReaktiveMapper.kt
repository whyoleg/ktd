package dev.whyoleg.ktd.client.api.reaktive

import com.badoo.reaktive.observable.*
import com.badoo.reaktive.subject.publish.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.*

object ReaktiveMapper : ResponseMapper<ReaktiveResponse, ReaktiveResponseHandler, Nothing> {
    override fun create(input: Nothing?): ReaktiveResponseHandler = PublishSubject()
    override fun complete(handler: ReaktiveResponseHandler, response: TelegramResponseOrError) {
        response.map(handler::onNext, handler::onError)
    }

    override fun getResponse(handler: ReaktiveResponseHandler): ReaktiveResponse = handler.firstOrError()
}
