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
 * Returns information about a message
 *
 * @chatId - Identifier of the chat the message belongs to
 * @messageId - Identifier of the message to get
 */
suspend fun TelegramClient.getMessage(
    chatId: Long = 0L,
    messageId: Long = 0L
): Message = message(
    GetMessage(
        chatId,
        messageId
    )
)

/**
 * Returns information about a message
 */
suspend fun TelegramClient.message(
    f: GetMessage
): Message = exec(f) as Message
