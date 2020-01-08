@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.notification

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Changes notification settings for chats of a given type
 *
 * @scope - Types of chats for which to change the notification settings
 * @notificationSettings - The new notification settings for the given scope
 */
suspend fun TelegramClient.setScopeNotificationSettings(
    scope: NotificationSettingsScope? = null,
    notificationSettings: ScopeNotificationSettings? = null
): Ok = notification(
    SetScopeNotificationSettings(
        scope,
        notificationSettings
    )
)

/**
 * Changes notification settings for chats of a given type
 */
suspend fun TelegramClient.notification(
    f: SetScopeNotificationSettings
): Ok = exec(f) as Ok
