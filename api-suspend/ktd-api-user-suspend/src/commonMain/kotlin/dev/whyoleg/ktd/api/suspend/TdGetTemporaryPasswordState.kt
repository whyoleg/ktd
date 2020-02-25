package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about the current temporary password
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getTemporaryPasswordState(extra: TdExtra = TdExtra.EMPTY):
        TdTemporaryPasswordState = exec(TdGetTemporaryPasswordState(extra))
