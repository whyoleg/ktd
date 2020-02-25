package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sends a custom request
 *
 * @property method The method name
 * @property parameters JSON-serialized method parameters
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.sendCustomRequest(
    method: String? = null,
    parameters: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdCustomRequestResult = exec(TdSendCustomRequest(method, parameters, extra))
