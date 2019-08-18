@file:Suppress("unused")

package dev.whyoleg.ktd.api.notification

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Removes an active notification from notification list. Needs to be called only if the notification is removed by the current user
 *
 * @notificationGroupId - Identifier of notification group to which the notification belongs
 * @notificationId - Identifier of removed notification
 */
suspend fun TelegramClient.removeNotification(
    notificationGroupId: Int,
    notificationId: Int
): Ok = notification(
    RemoveNotification(
        notificationGroupId,
        notificationId
    )
)

/**
 * Removes a group of active notifications. Needs to be called only if the notification group is removed by the current user
 *
 * @notificationGroupId - Notification group identifier
 * @maxNotificationId - Maximum identifier of removed notifications
 */
suspend fun TelegramClient.removeNotificationGroup(
    notificationGroupId: Int,
    maxNotificationId: Int
): Ok = notification(
    RemoveNotificationGroup(
        notificationGroupId,
        maxNotificationId
    )
)

/**
 * Resets all notification settings to their default values. By default, all chats are unmuted, the sound is set to "default" and message previews are shown
 */
suspend fun TelegramClient.resetAllNotificationSettings(): Ok = notification(
    ResetAllNotificationSettings()
)
