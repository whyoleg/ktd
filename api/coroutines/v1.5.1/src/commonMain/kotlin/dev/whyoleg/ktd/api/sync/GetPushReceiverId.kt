@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.sync

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
fun TelegramClient.Companion.getPushReceiverId(
    payload: String? = null
): PushReceiverId = execute(
    GetPushReceiverId(
        payload
    )
)

/**
 * Returns a globally unique push notification subscription identifier for identification of an account, which has received a push notification
 * This is an offline method
 * Can be called before authorization
 */
fun TelegramClient.Companion.execute(
    f: GetPushReceiverId
): PushReceiverId = exec(f) as PushReceiverId
