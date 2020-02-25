package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes an active notification from notification list
 * Needs to be called only if the notification is removed by the current user
 *
 * @property notificationGroupId Identifier of notification group to which the notification belongs
 * @property notificationId Identifier of removed notification
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.removeNotification(
    notificationGroupId: Int = 0,
    notificationId: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdRemoveNotification(notificationGroupId, notificationId, extra))
