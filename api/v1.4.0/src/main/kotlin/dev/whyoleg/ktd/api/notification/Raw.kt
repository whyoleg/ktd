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
 */
suspend fun TelegramClient.notification(
    f: RemoveNotification
): Ok = exec(f) as Ok

/**
 * Removes a group of active notifications
 * Needs to be called only if the notification group is removed by the current user
 */
suspend fun TelegramClient.notification(
    f: RemoveNotificationGroup
): Ok = exec(f) as Ok

/**
 * Returns the notification settings for chats of a given type
 */
suspend fun TelegramClient.notification(
    f: GetScopeNotificationSettings
): ScopeNotificationSettings = exec(f) as ScopeNotificationSettings

/**
 * Changes notification settings for chats of a given type
 */
suspend fun TelegramClient.notification(
    f: SetScopeNotificationSettings
): Ok = exec(f) as Ok

/**
 * Resets all notification settings to their default values
 * By default, all chats are unmuted, the sound is set to "default" and message previews are shown
 */
suspend fun TelegramClient.notification(
    f: ResetAllNotificationSettings
): Ok = exec(f) as Ok

/**
 * Handles a push notification
 * Returns error with code 406 if the push notification is not supported and connection to the server is required to fetch new data
 * Can be called before authorization
 */
suspend fun TelegramClient.notification(
    f: ProcessPushNotification
): Ok = exec(f) as Ok

/**
 * Returns a globally unique push notification subscription identifier for identification of an account, which has received a push notification
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
suspend fun TelegramClient.notification(
    f: GetPushReceiverId
): PushReceiverId = exec(f) as PushReceiverId
