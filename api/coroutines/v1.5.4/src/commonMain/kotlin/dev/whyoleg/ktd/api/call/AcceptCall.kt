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
 * Accepts an incoming call
 *
 * @callId - Call identifier
 * @protocol - Description of the call protocols supported by the client
 */
suspend fun TelegramClient.acceptCall(
    callId: Int = 0,
    protocol: CallProtocol? = null
): Ok = call(
    AcceptCall(
        callId,
        protocol
    )
)

/**
 * Accepts an incoming call
 */
suspend fun TelegramClient.call(
    f: AcceptCall
): Ok = exec(f) as Ok
