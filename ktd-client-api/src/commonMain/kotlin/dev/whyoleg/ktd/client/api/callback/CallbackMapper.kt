package dev.whyoleg.ktd.client.api.callback

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.*

object CallbackMapper : ResponseMapper<Unit, Callback, Callback> {
    override fun create(input: Callback?): Callback = input!!
    override fun complete(handler: Callback, response: TelegramResponseOrError) {
        response.map({ handler.invoke(it, null) }, { handler.invoke(null, it) })
    }

    override fun getResponse(handler: Callback) = Unit
}
