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
 * Returns a list of frequently used chats
 * Supported only if the chat info database is enabled
 *
 * @category - Category of chats to be returned
 * @limit - Maximum number of chats to be returned
 *          Up to 30
 */
suspend fun TelegramClient.getTopChats(
    category: TopChatCategory? = null,
    limit: Int = 0
): Chats = chat(
    GetTopChats(
        category,
        limit
    )
)

/**
 * Returns a list of frequently used chats
 * Supported only if the chat info database is enabled
 */
suspend fun TelegramClient.chat(
    f: GetTopChats
): Chats = exec(f) as Chats
