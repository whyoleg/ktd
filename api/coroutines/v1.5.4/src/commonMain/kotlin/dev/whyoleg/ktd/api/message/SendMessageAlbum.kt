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
 * Sends messages grouped together into an album
 * Currently only photo and video messages can be grouped into an album
 * Returns sent messages
 *
 * @chatId - Target chat
 * @replyToMessageId - Identifier of a message to reply to or 0
 * @options - Options to be used to send the messages
 * @inputMessageContents - Contents of messages to be sent
 */
suspend fun TelegramClient.sendMessageAlbum(
    chatId: Long = 0L,
    replyToMessageId: Long = 0L,
    options: SendMessageOptions? = null,
    inputMessageContents: Array<InputMessageContent> = emptyArray()
): Messages = message(
    SendMessageAlbum(
        chatId,
        replyToMessageId,
        options,
        inputMessageContents
    )
)

/**
 * Sends messages grouped together into an album
 * Currently only photo and video messages can be grouped into an album
 * Returns sent messages
 */
suspend fun TelegramClient.message(
    f: SendMessageAlbum
): Messages = exec(f) as Messages
