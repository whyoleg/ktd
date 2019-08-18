@file:Suppress("unused")

package dev.whyoleg.ktd.api.notification

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Removes an active notification from notification list. Needs to be called only if the notification is removed by the current user
 */
suspend fun TelegramClient.notification(
    f: RemoveNotification
): Ok = execRaw(f) as Ok

/**
 * Removes a group of active notifications. Needs to be called only if the notification group is removed by the current user
 */
suspend fun TelegramClient.notification(
    f: RemoveNotificationGroup
): Ok = execRaw(f) as Ok

/**
 * Resets all notification settings to their default values. By default, all chats are unmuted, the sound is set to "default" and message previews are shown
 */
suspend fun TelegramClient.notification(
    f: ResetAllNotificationSettings
): Ok = execRaw(f) as Ok
