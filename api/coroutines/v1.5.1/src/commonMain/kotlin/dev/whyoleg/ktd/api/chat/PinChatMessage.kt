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
 * Pins a message in a chat
 * Requires can_pin_messages rights
 *
 * @chatId - Identifier of the chat
 * @messageId - Identifier of the new pinned message
 * @disableNotification - True, if there should be no notification about the pinned message
 */
suspend fun TelegramClient.pinChatMessage(
    chatId: Long = 0L,
    messageId: Long = 0L,
    disableNotification: Boolean = false
): Ok = chat(
    PinChatMessage(
        chatId,
        messageId,
        disableNotification
    )
)

/**
 * Pins a message in a chat
 * Requires can_pin_messages rights
 */
suspend fun TelegramClient.chat(
    f: PinChatMessage
): Ok = exec(f) as Ok
