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
 * Discards a call
 *
 * @callId - Call identifier
 * @isDisconnected - True, if the user was disconnected
 * @duration - The call duration, in seconds
 * @connectionId - Identifier of the connection used during the call
 */
suspend fun TelegramClient.discardCall(
    callId: Int = 0,
    isDisconnected: Boolean = false,
    duration: Int = 0,
    connectionId: Long = 0L
): Ok = call(
    DiscardCall(
        callId,
        isDisconnected,
        duration,
        connectionId
    )
)

/**
 * Discards a call
 */
suspend fun TelegramClient.call(
    f: DiscardCall
): Ok = exec(f) as Ok
