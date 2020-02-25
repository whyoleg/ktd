package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns a globally unique push notification subscription identifier for identification of an account, which has received a push notification
 * This is an offline method
 * Can be called before authorization
 *
 * @property payload JSON-encoded push notification payload
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getPushReceiverId(payload: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdPushReceiverId = exec(TdGetPushReceiverId(payload, extra))
