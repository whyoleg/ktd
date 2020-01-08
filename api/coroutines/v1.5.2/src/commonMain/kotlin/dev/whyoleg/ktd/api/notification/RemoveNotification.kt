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
 * Removes an active notification from notification list
 * Needs to be called only if the notification is removed by the current user
 */
suspend fun TelegramClient.notification(
    f: RemoveNotification
): Ok = exec(f) as Ok
