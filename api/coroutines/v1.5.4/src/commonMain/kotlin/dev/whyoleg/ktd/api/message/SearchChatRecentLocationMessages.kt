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
 * Returns information about the recent locations of chat members that were sent to the chat
 * Returns up to 1 location message per user
 *
 * @chatId - Chat identifier
 * @limit - Maximum number of messages to be returned
 */
suspend fun TelegramClient.searchChatRecentLocationMessages(
    chatId: Long = 0L,
    limit: Int = 0
): Messages = message(
    SearchChatRecentLocationMessages(
        chatId,
        limit
    )
)

/**
 * Returns information about the recent locations of chat members that were sent to the chat
 * Returns up to 1 location message per user
 */
suspend fun TelegramClient.message(
    f: SearchChatRecentLocationMessages
): Messages = exec(f) as Messages
