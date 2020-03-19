package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Saves application log event on the server
 * Can be called before authorization
 *
 * @property type Event type
 * @property chatId Optional chat identifier, associated with the event
 * @property data The log event data
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.saveApplicationLogEvent(
    type: String? = null,
    chatId: Long = 0L,
    data: TdJsonValue? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSaveApplicationLogEvent(type, chatId, data, extra))
