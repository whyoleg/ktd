package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends messages grouped together into an album
 * Currently only photo and video messages can be grouped into an album
 * Returns sent messages
 *
 * @property chatId Target chat
 * @property replyToMessageId Identifier of a message to reply to or 0
 * @property options Options to be used to send the messages
 * @property inputMessageContents Contents of messages to be sent
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendMessageAlbum(
    chatId: Long = 0L,
    replyToMessageId: Long = 0L,
    options: TdSendMessageOptions? = null,
    inputMessageContents: List<TdInputMessageContent> = emptyList(),
    extra: TdExtra = TdExtra.EMPTY
): TdMessages = exec(TdSendMessageAlbum(chatId, replyToMessageId, options, inputMessageContents,
        extra))
