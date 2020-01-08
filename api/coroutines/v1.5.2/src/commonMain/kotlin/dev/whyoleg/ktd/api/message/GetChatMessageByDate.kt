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
 * Returns the last message sent in a chat no later than the specified date
 *
 * @chatId - Chat identifier
 * @date - Point in time (Unix timestamp) relative to which to search for messages
 */
suspend fun TelegramClient.getChatMessageByDate(
    chatId: Long = 0L,
    date: Int = 0
): Message = message(
    GetChatMessageByDate(
        chatId,
        date
    )
)

/**
 * Returns the last message sent in a chat no later than the specified date
 */
suspend fun TelegramClient.message(
    f: GetChatMessageByDate
): Message = exec(f) as Message
