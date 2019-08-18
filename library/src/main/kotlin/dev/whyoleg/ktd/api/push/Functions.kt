@file:Suppress("unused")

package dev.whyoleg.ktd.api.push

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Registers the currently used device for receiving push notifications. Returns a globally unique identifier of the push notification subscription
 */
suspend fun TelegramClient.push(
    f: RegisterDevice
): PushReceiverId = execRaw(f) as PushReceiverId

/**
 * Handles a push notification. Returns error with code 406 if the push notification is not supported and connection to the server is required to fetch new data. Can be called before authorization
 */
suspend fun TelegramClient.push(
    f: ProcessPushNotification
): Ok = execRaw(f) as Ok

/**
 * Returns a globally unique push notification subscription identifier for identification of an account, which has received a push notification. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.push(
    f: GetPushReceiverId
): PushReceiverId = execRaw(f) as PushReceiverId
