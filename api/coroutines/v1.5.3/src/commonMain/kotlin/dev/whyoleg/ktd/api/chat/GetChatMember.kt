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
 * Returns information about a single member of a chat
 *
 * @chatId - Chat identifier
 * @userId - User identifier
 */
suspend fun TelegramClient.getChatMember(
    chatId: Long = 0L,
    userId: Int = 0
): ChatMember = chat(
    GetChatMember(
        chatId,
        userId
    )
)

/**
 * Returns information about a single member of a chat
 */
suspend fun TelegramClient.chat(
    f: GetChatMember
): ChatMember = exec(f) as ChatMember
