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
 * Returns a list of common group chats with a given user
 * Chats are sorted by their type and creation date
 *
 * @userId - User identifier
 * @offsetChatId - Chat identifier starting from which to return chats
 *                 Use 0 for the first request
 * @limit - Maximum number of chats to be returned
 */
suspend fun TelegramClient.getGroupsInCommon(
    userId: Int = 0,
    offsetChatId: Long = 0L,
    limit: Int = 0
): Chats = chat(
    GetGroupsInCommon(
        userId,
        offsetChatId,
        limit
    )
)

/**
 * Returns a list of common group chats with a given user
 * Chats are sorted by their type and creation date
 */
suspend fun TelegramClient.chat(
    f: GetGroupsInCommon
): Chats = exec(f) as Chats
