@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Forwards previously sent messages
 * Returns the forwarded messages in the same order as the message identifiers passed in message_ids
 * If a message can't be forwarded, null will be returned instead of the message
 *
 * @chatId - Identifier of the chat to which to forward messages
 * @fromChatId - Identifier of the chat from which to forward messages
 * @messageIds - Identifiers of the messages to forward
 * @options - Options to be used to send the messages
 * @asAlbum - True, if the messages should be grouped into an album after forwarding
 *            For this to work, no more than 10 messages may be forwarded, and all of them must be photo or video messages
 * @sendCopy - True, if content of the messages needs to be copied without links to the original messages
 *             Always true if the messages are forwarded to a secret chat
 * @removeCaption - True, if media captions of message copies needs to be removed
 *                  Ignored if send_copy is false
 */
suspend fun TelegramClient.forwardMessages(
    chatId: Long = 0L,
    fromChatId: Long = 0L,
    messageIds: LongArray = longArrayOf(),
    options: SendMessageOptions? = null,
    asAlbum: Boolean = false,
    sendCopy: Boolean = false,
    removeCaption: Boolean = false
): Messages = message(
    ForwardMessages(
        chatId,
        fromChatId,
        messageIds,
        options,
        asAlbum,
        sendCopy,
        removeCaption
    )
)

/**
 * Forwards previously sent messages
 * Returns the forwarded messages in the same order as the message identifiers passed in message_ids
 * If a message can't be forwarded, null will be returned instead of the message
 */
suspend fun TelegramClient.message(
    f: ForwardMessages
): Messages = exec(f) as Messages
