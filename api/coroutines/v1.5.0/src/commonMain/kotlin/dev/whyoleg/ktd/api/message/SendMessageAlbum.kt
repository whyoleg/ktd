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
 * @disableNotification - Pass true to disable notification for the messages
 *                        Not supported in secret chats
 * @fromBackground - Pass true if the messages are sent from the background
 * @inputMessageContents - Contents of messages to be sent
 */
suspend fun TelegramClient.sendMessageAlbum(
    chatId: Long = 0L,
    replyToMessageId: Long = 0L,
    disableNotification: Boolean = false,
    fromBackground: Boolean = false,
    inputMessageContents: Array<InputMessageContent> = emptyArray()
): Messages = message(
    SendMessageAlbum(
        chatId,
        replyToMessageId,
        disableNotification,
        fromBackground,
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
