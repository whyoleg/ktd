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
 * Removes an active notification from notification list
 * Needs to be called only if the notification is removed by the current user
 *
 * @notificationGroupId - Identifier of notification group to which the notification belongs
 * @notificationId - Identifier of removed notification
 */
suspend fun TelegramClient.removeNotification(
    notificationGroupId: Int = 0,
    notificationId: Int = 0
): Ok = notification(
    RemoveNotification(
        notificationGroupId,
        notificationId
    )
)

/**
 * Removes a group of active notifications
 * Needs to be called only if the notification group is removed by the current user
 *
 * @notificationGroupId - Notification group identifier
 * @maxNotificationId - Maximum identifier of removed notifications
 */
suspend fun TelegramClient.removeNotificationGroup(
    notificationGroupId: Int = 0,
    maxNotificationId: Int = 0
): Ok = notification(
    RemoveNotificationGroup(
        notificationGroupId,
        maxNotificationId
    )
)

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
 * Resets all notification settings to their default values
 * By default, all chats are unmuted, the sound is set to "default" and message previews are shown
 */
suspend fun TelegramClient.resetAllNotificationSettings(): Ok = notification(
    ResetAllNotificationSettings()
)

/**
 * Handles a push notification
 * Returns error with code 406 if the push notification is not supported and connection to the server is required to fetch new data
 * Can be called before authorization
 *
 * @payload - JSON-encoded push notification payload with all fields sent by the server, and "google.sent_time" and "google.notification.sound" fields added
 */
suspend fun TelegramClient.processPushNotification(
    payload: String? = null
): Ok = notification(
    ProcessPushNotification(
        payload
    )
)

/**
 * Returns a globally unique push notification subscription identifier for identification of an account, which has received a push notification
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @payload - JSON-encoded push notification payload
 */
suspend fun TelegramClient.getPushReceiverId(
    payload: String? = null
): PushReceiverId = notification(
    GetPushReceiverId(
        payload
    )
)
