@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.chat

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns approximate number of messages of the specified type in the chat
 *
 * @chatId - Identifier of the chat in which to count messages
 * @filter - Filter for message content
 *           SearchMessagesFilterEmpty is unsupported in this function
 * @returnLocal - If true, returns count that is available locally without sending network requests, returning -1 if the number of messages is unknown
 */
suspend fun TelegramClient.getChatMessageCount(
    chatId: Long = 0L,
    filter: SearchMessagesFilter? = null,
    returnLocal: Boolean = false
): Count = chat(
    GetChatMessageCount(
        chatId,
        filter,
        returnLocal
    )
)

/**
 * Returns approximate number of messages of the specified type in the chat
 */
suspend fun TelegramClient.chat(
    f: GetChatMessageCount
): Count = exec(f) as Count
