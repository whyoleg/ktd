package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*

object TelegramRawClient {

    init {
        loadTdlib()
    }

    external fun create(): Long
    external fun destroy(clientId: Long)

    external fun send(clientId: Long, eventId: Long, function: TelegramFunction)
    external fun receive(clientId: Long, eventIds: LongArray, events: Array<TelegramObject?>, timeout: Double): Int

    external fun execute(function: TelegramFunction): TelegramObject

}
