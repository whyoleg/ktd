package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Deletes saved credentials for all payment provider bots
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.deleteSavedCredentials(extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdDeleteSavedCredentials(extra))
