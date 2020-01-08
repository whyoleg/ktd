@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.custom

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sends a custom request
 *
 * @method - The method name
 * @parameters - JSON-serialized method parameters
 */
@BotsOnly
suspend fun TelegramClient.sendCustomRequest(
    method: String? = null,
    parameters: String? = null
): CustomRequestResult = custom(
    SendCustomRequest(
        method,
        parameters
    )
)

/**
 * Sends a custom request
 */
@BotsOnly
suspend fun TelegramClient.custom(
    f: SendCustomRequest
): CustomRequestResult = exec(f) as CustomRequestResult
