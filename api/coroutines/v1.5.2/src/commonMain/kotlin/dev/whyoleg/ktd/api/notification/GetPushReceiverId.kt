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
 * Returns a globally unique push notification subscription identifier for identification of an account, which has received a push notification
 * This is an offline method
 * Can be called before authorization
 *
 * @payload - JSON-encoded push notification payload
 */
suspend fun TelegramClient.getPushReceiverId(
    payload: String? = null
): PushReceiverId = notification(
    GetPushReceiverId(
        payload
    )
)

/**
 * Returns a globally unique push notification subscription identifier for identification of an account, which has received a push notification
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.notification(
    f: GetPushReceiverId
): PushReceiverId = exec(f) as PushReceiverId
