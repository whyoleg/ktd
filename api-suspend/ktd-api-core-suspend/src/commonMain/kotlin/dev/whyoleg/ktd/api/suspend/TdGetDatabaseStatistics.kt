package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns database statistics
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getDatabaseStatistics(extra: TdExtra = TdExtra.EMPTY):
        TdDatabaseStatistics = exec(TdGetDatabaseStatistics(extra))
