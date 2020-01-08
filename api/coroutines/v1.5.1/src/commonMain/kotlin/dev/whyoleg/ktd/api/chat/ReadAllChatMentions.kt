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
 * Marks all mentions in a chat as read
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.readAllChatMentions(
    chatId: Long = 0L
): Ok = chat(
    ReadAllChatMentions(
        chatId
    )
)

/**
 * Marks all mentions in a chat as read
 */
suspend fun TelegramClient.chat(
    f: ReadAllChatMentions
): Ok = exec(f) as Ok
