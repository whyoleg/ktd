@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.check

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Checks whether a username can be set for a chat
 *
 * @chatId - Chat identifier
 *           Should be identifier of a supergroup chat, or a channel chat, or a private chat with self, or zero if chat is being created
 * @username - Username to be checked
 */
suspend fun TelegramClient.checkChatUsername(
    chatId: Long = 0L,
    username: String? = null
): CheckChatUsernameResult = check(
    CheckChatUsername(
        chatId,
        username
    )
)

/**
 * Checks whether a username can be set for a chat
 */
suspend fun TelegramClient.check(
    f: CheckChatUsername
): CheckChatUsernameResult = exec(f) as CheckChatUsernameResult
