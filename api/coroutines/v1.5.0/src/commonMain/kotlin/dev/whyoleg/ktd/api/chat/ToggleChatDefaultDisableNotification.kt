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
 * Changes the value of the default disable_notification parameter, used when a message is sent to a chat
 *
 * @chatId - Chat identifier
 * @defaultDisableNotification - New value of default_disable_notification
 */
suspend fun TelegramClient.toggleChatDefaultDisableNotification(
    chatId: Long = 0L,
    defaultDisableNotification: Boolean = false
): Ok = chat(
    ToggleChatDefaultDisableNotification(
        chatId,
        defaultDisableNotification
    )
)

/**
 * Changes the value of the default disable_notification parameter, used when a message is sent to a chat
 */
suspend fun TelegramClient.chat(
    f: ToggleChatDefaultDisableNotification
): Ok = exec(f) as Ok
