@file:Suppress("unused")

package dev.whyoleg.ktd.api.push

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Registers the currently used device for receiving push notifications. Returns a globally unique identifier of the push notification subscription
 *
 * @deviceToken - Device token
 * @otherUserIds - List of user identifiers of other users currently using the client
 */
suspend fun TelegramClient.registerDevice(
    deviceToken: DeviceToken,
    otherUserIds: IntArray
): PushReceiverId = push(
    RegisterDevice(
        deviceToken,
        otherUserIds
    )
)

/**
 * Handles a push notification. Returns error with code 406 if the push notification is not supported and connection to the server is required to fetch new data. Can be called before authorization
 *
 * @payload - JSON-encoded push notification payload with all fields sent by the server, and "google.sent_time" and "google.notification.sound" fields added
 */
suspend fun TelegramClient.processPushNotification(
    payload: String
): Ok = push(
    ProcessPushNotification(
        payload
    )
)

/**
 * Returns a globally unique push notification subscription identifier for identification of an account, which has received a push notification. This is an offline method. Can be called before authorization. Can be called synchronously
 *
 * @payload - JSON-encoded push notification payload
 */
suspend fun TelegramClient.getPushReceiverId(
    payload: String
): PushReceiverId = push(
    GetPushReceiverId(
        payload
    )
)
