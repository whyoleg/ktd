package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends debug information for a call
 *
 * @property callId Call identifier
 * @property debugInformation Debug information in application-specific format
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendCallDebugInformation(
    callId: Int = 0,
    debugInformation: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSendCallDebugInformation(callId, debugInformation, extra))
