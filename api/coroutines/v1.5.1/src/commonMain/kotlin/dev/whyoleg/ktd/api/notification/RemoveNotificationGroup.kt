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
 * Removes a group of active notifications
 * Needs to be called only if the notification group is removed by the current user
 */
suspend fun TelegramClient.notification(
    f: RemoveNotificationGroup
): Ok = exec(f) as Ok
