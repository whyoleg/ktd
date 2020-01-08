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
 * Changes the notification settings of a chat
 *
 * @chatId - Chat identifier
 * @notificationSettings - New notification settings for the chat
 */
suspend fun TelegramClient.setChatNotificationSettings(
    chatId: Long = 0L,
    notificationSettings: ChatNotificationSettings? = null
): Ok = chat(
    SetChatNotificationSettings(
        chatId,
        notificationSettings
    )
)

/**
 * Changes the notification settings of a chat
 */
suspend fun TelegramClient.chat(
    f: SetChatNotificationSettings
): Ok = exec(f) as Ok
