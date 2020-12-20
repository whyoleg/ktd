package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Stops a poll
 * A poll in a message can be stopped when the message has can_be_edited flag set
 *
 * @property chatId Identifier of the chat to which the poll belongs
 * @property messageId Identifier of the message containing the poll
 * @property replyMarkup The new message reply markup
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.stopPoll(
    chatId: Long = 0L,
    messageId: Long = 0L,
    replyMarkup: TdReplyMarkup? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdStopPoll(chatId, messageId, replyMarkup, extra))
