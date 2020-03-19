package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds the specified data to data usage statistics
 * Can be called before authorization
 *
 * @property entry The network statistics entry with the data to be added to statistics
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.addNetworkStatistics(entry: TdNetworkStatisticsEntry? = null,
        extra: TdExtra = TdExtra.EMPTY): TdOk = exec(TdAddNetworkStatistics(entry, extra))
