@file:Suppress("unused")

package dev.whyoleg.ktd.api.scope

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the notification settings for chats of a given type
 *
 * @scope - Types of chats for which to return the notification settings information
 */
suspend fun TelegramClient.getScopeNotificationSettings(
    scope: NotificationSettingsScope
): ScopeNotificationSettings = scope(
    GetScopeNotificationSettings(
        scope
    )
)

/**
 * Changes notification settings for chats of a given type
 *
 * @scope - Types of chats for which to change the notification settings
 * @notificationSettings - The new notification settings for the given scope
 */
suspend fun TelegramClient.setScopeNotificationSettings(
    scope: NotificationSettingsScope,
    notificationSettings: ScopeNotificationSettings
): Ok = scope(
    SetScopeNotificationSettings(
        scope,
        notificationSettings
    )
)
