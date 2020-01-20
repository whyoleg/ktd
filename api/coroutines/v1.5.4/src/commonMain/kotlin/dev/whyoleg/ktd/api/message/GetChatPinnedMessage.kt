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
 * Returns information about a pinned chat message
 *
 * @chatId - Identifier of the chat the message belongs to
 */
suspend fun TelegramClient.getChatPinnedMessage(
    chatId: Long = 0L
): Message = message(
    GetChatPinnedMessage(
        chatId
    )
)

/**
 * Returns information about a pinned chat message
 */
suspend fun TelegramClient.message(
    f: GetChatPinnedMessage
): Message = exec(f) as Message
