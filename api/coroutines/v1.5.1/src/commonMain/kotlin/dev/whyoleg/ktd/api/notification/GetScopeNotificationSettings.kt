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
 * Returns the notification settings for chats of a given type
 *
 * @scope - Types of chats for which to return the notification settings information
 */
suspend fun TelegramClient.getScopeNotificationSettings(
    scope: NotificationSettingsScope? = null
): ScopeNotificationSettings = notification(
    GetScopeNotificationSettings(
        scope
    )
)

/**
 * Returns the notification settings for chats of a given type
 */
suspend fun TelegramClient.notification(
    f: GetScopeNotificationSettings
): ScopeNotificationSettings = exec(f) as ScopeNotificationSettings
