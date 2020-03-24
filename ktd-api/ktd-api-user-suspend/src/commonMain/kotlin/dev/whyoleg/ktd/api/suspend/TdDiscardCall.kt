package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Discards a call
 *
 * @property callId Call identifier
 * @property isDisconnected True, if the user was disconnected
 * @property duration The call duration, in seconds
 * @property connectionId Identifier of the connection used during the call
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.discardCall(
    callId: Int = 0,
    isDisconnected: Boolean = false,
    duration: Int = 0,
    connectionId: Long = 0L,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdDiscardCall(callId, isDisconnected, duration, connectionId, extra))
