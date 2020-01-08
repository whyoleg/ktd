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
 * Returns information about a message that is replied by given message
 *
 * @chatId - Identifier of the chat the message belongs to
 * @messageId - Identifier of the message reply to which get
 */
suspend fun TelegramClient.getRepliedMessage(
    chatId: Long = 0L,
    messageId: Long = 0L
): Message = message(
    GetRepliedMessage(
        chatId,
        messageId
    )
)

/**
 * Returns information about a message that is replied by given message
 */
suspend fun TelegramClient.message(
    f: GetRepliedMessage
): Message = exec(f) as Message
