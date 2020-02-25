package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the current state of 2-step verification
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getPasswordState(extra: TdExtra = TdExtra.EMPTY): TdPasswordState =
        exec(TdGetPasswordState(extra))
