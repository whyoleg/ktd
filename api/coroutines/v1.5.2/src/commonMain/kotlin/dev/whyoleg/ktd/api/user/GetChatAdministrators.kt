@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.user

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a list of users who are administrators of the chat
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.getChatAdministrators(
    chatId: Long = 0L
): Users = user(
    GetChatAdministrators(
        chatId
    )
)

/**
 * Returns a list of users who are administrators of the chat
 */
suspend fun TelegramClient.user(
    f: GetChatAdministrators
): Users = exec(f) as Users
