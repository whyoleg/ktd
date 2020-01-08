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
 * Returns all scheduled messages in a chat
 * The messages are returned in a reverse chronological order (i.e., in order of decreasing message_id)
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.getChatScheduledMessages(
    chatId: Long = 0L
): Messages = message(
    GetChatScheduledMessages(
        chatId
    )
)

/**
 * Returns all scheduled messages in a chat
 * The messages are returned in a reverse chronological order (i.e., in order of decreasing message_id)
 */
suspend fun TelegramClient.message(
    f: GetChatScheduledMessages
): Messages = exec(f) as Messages
