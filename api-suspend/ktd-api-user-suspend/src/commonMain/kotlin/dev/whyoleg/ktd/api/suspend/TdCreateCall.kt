package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Creates a new call
 *
 * @property userId Identifier of the user to be called
 * @property protocol Description of the call protocols supported by the client
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.createCall(
    userId: Int = 0,
    protocol: TdCallProtocol? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdCallId = exec(TdCreateCall(userId, protocol, extra))
