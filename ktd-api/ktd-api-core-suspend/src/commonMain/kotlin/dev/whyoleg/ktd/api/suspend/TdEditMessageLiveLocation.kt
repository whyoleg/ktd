package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Edits the message content of a live location
 * Messages can be edited for a limited period of time specified in the live location
 * Returns the edited message after the edit is completed on the server side
 *
 * @property chatId The chat the message belongs to
 * @property messageId Identifier of the message
 * @property replyMarkup The new message reply markup
 * @property location New location content of the message
 *                    Pass null to stop sharing the live location
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.editMessageLiveLocation(
    chatId: Long = 0L,
    messageId: Long = 0L,
    location: TdLocation? = null,
    replyMarkup: TdReplyMarkup? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdMessage = exec(TdEditMessageLiveLocation(chatId, messageId, location, replyMarkup, extra))
