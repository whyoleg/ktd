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
 * Changes the slow mode delay of a chat
 * Available only for supergroups
 * Requires can_restrict_members rights
 *
 * @chatId - Chat identifier
 * @slowModeDelay - New slow mode delay for the chat
 *                  Must be one of 0, 10, 30, 60, 300, 900, 3600
 */
suspend fun TelegramClient.setChatSlowModeDelay(
    chatId: Long = 0L,
    slowModeDelay: Int = 0
): Ok = chat(
    SetChatSlowModeDelay(
        chatId,
        slowModeDelay
    )
)

/**
 * Changes the slow mode delay of a chat
 * Available only for supergroups
 * Requires can_restrict_members rights
 */
suspend fun TelegramClient.chat(
    f: SetChatSlowModeDelay
): Ok = exec(f) as Ok
