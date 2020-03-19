package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Accepts an incoming call
 *
 * @property callId Call identifier
 * @property protocol Description of the call protocols supported by the client
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.acceptCall(
    callId: Int = 0,
    protocol: TdCallProtocol? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdAcceptCall(callId, protocol, extra))
