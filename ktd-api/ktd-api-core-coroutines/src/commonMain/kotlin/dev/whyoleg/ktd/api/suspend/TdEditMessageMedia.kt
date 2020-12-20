package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Edits the content of a message with an animation, an audio, a document, a photo or a video
 * The media in the message can't be replaced if the message was set to self-destruct
 * Media can't be replaced by self-destructing media
 * Media in an album can be edited only to contain a photo or a video
 * Returns the edited message after the edit is completed on the server side
 *
 * @property chatId The chat the message belongs to
 * @property messageId Identifier of the message
 * @property replyMarkup The new message reply markup
 * @property inputMessageContent New content of the message
 *                               Must be one of the following types: InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or InputMessageVideo
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.editMessageMedia(
    chatId: Long = 0L,
    messageId: Long = 0L,
    inputMessageContent: TdInputMessageContent? = null,
    replyMarkup: TdReplyMarkup? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdMessage = exec(TdEditMessageMedia(chatId, messageId, inputMessageContent, replyMarkup, extra))
