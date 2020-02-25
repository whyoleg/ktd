package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Informs TDLib that the message content has been opened (e.g., the user has opened a photo, video, document, location or venue, or has listened to an audio file or voice note message)
 * An updateMessageContentOpened update will be generated if something has changed
 *
 * @property chatId Chat identifier of the message
 * @property messageId Identifier of the message with the opened content
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.openMessageContent(
    chatId: Long = 0L,
    messageId: Long = 0L,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdOpenMessageContent(chatId, messageId, extra))
