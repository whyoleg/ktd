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
 * Returns a private HTTPS link to a message in a chat
 * Available only for already sent messages in supergroups and channels
 * The link will work only for members of the chat
 *
 * @chatId - Identifier of the chat to which the message belongs
 * @messageId - Identifier of the message
 */
suspend fun TelegramClient.getMessageLink(
    chatId: Long = 0L,
    messageId: Long = 0L
): HttpUrl = message(
    GetMessageLink(
        chatId,
        messageId
    )
)

/**
 * Returns a private HTTPS link to a message in a chat
 * Available only for already sent messages in supergroups and channels
 * The link will work only for members of the chat
 */
suspend fun TelegramClient.message(
    f: GetMessageLink
): HttpUrl = exec(f) as HttpUrl
