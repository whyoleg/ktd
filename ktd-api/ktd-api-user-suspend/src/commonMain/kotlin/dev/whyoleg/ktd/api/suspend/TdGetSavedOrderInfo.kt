package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns saved order info, if any
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getSavedOrderInfo(extra: TdExtra = TdExtra.EMPTY): TdOrderInfo =
        exec(TdGetSavedOrderInfo(extra))
