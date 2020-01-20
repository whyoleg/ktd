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
 * Removes the pinned message from a chat
 * Requires can_pin_messages rights in the group or channel
 *
 * @chatId - Identifier of the chat
 */
suspend fun TelegramClient.unpinChatMessage(
    chatId: Long = 0L
): Ok = chat(
    UnpinChatMessage(
        chatId
    )
)

/**
 * Removes the pinned message from a chat
 * Requires can_pin_messages rights in the group or channel
 */
suspend fun TelegramClient.chat(
    f: UnpinChatMessage
): Ok = exec(f) as Ok
