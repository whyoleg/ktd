package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Deletes saved order info
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.deleteSavedOrderInfo(extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdDeleteSavedOrderInfo(extra))
