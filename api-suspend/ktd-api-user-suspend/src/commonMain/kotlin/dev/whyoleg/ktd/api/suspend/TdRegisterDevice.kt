package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Registers the currently used device for receiving push notifications
 * Returns a globally unique identifier of the push notification subscription
 *
 * @property deviceToken Device token
 * @property otherUserIds List of user identifiers of other users currently using the client
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.registerDevice(
    deviceToken: TdDeviceToken? = null,
    otherUserIds: IntArray = intArrayOf(),
    extra: TdExtra = TdExtra.EMPTY
): TdPushReceiverId = exec(TdRegisterDevice(deviceToken, otherUserIds, extra))
