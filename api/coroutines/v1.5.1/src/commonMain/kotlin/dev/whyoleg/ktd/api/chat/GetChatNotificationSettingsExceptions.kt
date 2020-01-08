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
 * Returns list of chats with non-default notification settings
 *
 * @scope - If specified, only chats from the specified scope will be returned
 * @compareSound - If true, also chats with non-default sound will be returned
 */
suspend fun TelegramClient.getChatNotificationSettingsExceptions(
    scope: NotificationSettingsScope? = null,
    compareSound: Boolean = false
): Chats = chat(
    GetChatNotificationSettingsExceptions(
        scope,
        compareSound
    )
)

/**
 * Returns list of chats with non-default notification settings
 */
suspend fun TelegramClient.chat(
    f: GetChatNotificationSettingsExceptions
): Chats = exec(f) as Chats
