package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Quickly returns approximate storage usage statistics
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getStorageStatisticsFast(extra: TdExtra = TdExtra.EMPTY):
        TdStorageStatisticsFast = exec(TdGetStorageStatisticsFast(extra))
