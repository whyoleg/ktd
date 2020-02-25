package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends a message
 * Returns the sent message
 *
 * @property chatId Target chat
 * @property replyToMessageId Identifier of the message to reply to or 0
 * @property options Options to be used to send the message
 * @property replyMarkup Markup for replying to the message
 * @property inputMessageContent The content of the message to be sent
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendMessage(
    chatId: Long = 0L,
    replyToMessageId: Long = 0L,
    options: TdSendMessageOptions? = null,
    inputMessageContent: TdInputMessageContent? = null,
    replyMarkup: TdReplyMarkup? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdMessage = exec(TdSendMessage(chatId, replyToMessageId, options, inputMessageContent,
        replyMarkup, extra))
