package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes a group of active notifications
 * Needs to be called only if the notification group is removed by the current user
 *
 * @property notificationGroupId Notification group identifier
 * @property maxNotificationId The maximum identifier of removed notifications
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.removeNotificationGroup(
    notificationGroupId: Int = 0,
    maxNotificationId: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdRemoveNotificationGroup(notificationGroupId, maxNotificationId, extra))
