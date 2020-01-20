@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.call

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sends debug information for a call
 *
 * @callId - Call identifier
 * @debugInformation - Debug information in application-specific format
 */
suspend fun TelegramClient.sendCallDebugInformation(
    callId: Int = 0,
    debugInformation: String? = null
): Ok = call(
    SendCallDebugInformation(
        callId,
        debugInformation
    )
)

/**
 * Sends debug information for a call
 */
suspend fun TelegramClient.call(
    f: SendCallDebugInformation
): Ok = exec(f) as Ok
