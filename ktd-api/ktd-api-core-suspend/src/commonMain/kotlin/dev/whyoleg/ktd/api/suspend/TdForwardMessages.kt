package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Forwards previously sent messages
 * Returns the forwarded messages in the same order as the message identifiers passed in message_ids
 * If a message can't be forwarded, null will be returned instead of the message
 *
 * @property chatId Identifier of the chat to which to forward messages
 * @property fromChatId Identifier of the chat from which to forward messages
 * @property messageIds Identifiers of the messages to forward
 * @property options Options to be used to send the messages
 * @property asAlbum True, if the messages should be grouped into an album after forwarding
 *                   For this to work, no more than 10 messages may be forwarded, and all of them must be photo or video messages
 * @property sendCopy True, if content of the messages needs to be copied without links to the original messages
 *                    Always true if the messages are forwarded to a secret chat
 * @property removeCaption True, if media captions of message copies needs to be removed
 *                         Ignored if send_copy is false
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.forwardMessages(
    chatId: Long = 0L,
    fromChatId: Long = 0L,
    messageIds: LongArray = longArrayOf(),
    options: TdSendMessageOptions? = null,
    asAlbum: Boolean = false,
    sendCopy: Boolean = false,
    removeCaption: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdMessages = exec(TdForwardMessages(chatId, fromChatId, messageIds, options, asAlbum, sendCopy,
        removeCaption, extra))
