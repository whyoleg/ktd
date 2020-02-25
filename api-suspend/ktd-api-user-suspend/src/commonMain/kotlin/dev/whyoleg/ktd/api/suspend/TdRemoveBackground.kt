package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes background from the list of installed backgrounds
 *
 * @property backgroundId The background identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.removeBackground(backgroundId: Long = 0L, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdRemoveBackground(backgroundId, extra))
