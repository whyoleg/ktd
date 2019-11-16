@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.device

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Registers the currently used device for receiving push notifications
 * Returns a globally unique identifier of the push notification subscription
 *
 * @deviceToken - Device token
 * @otherUserIds - List of user identifiers of other users currently using the client
 */
suspend fun TelegramClient.registerDevice(
    deviceToken: DeviceToken,
    otherUserIds: IntArray = intArrayOf()
): PushReceiverId = device(
    RegisterDevice(
        deviceToken,
        otherUserIds
    )
)
