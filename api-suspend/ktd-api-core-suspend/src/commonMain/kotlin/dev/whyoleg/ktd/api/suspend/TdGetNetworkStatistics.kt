package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns network data usage statistics
 * Can be called before authorization
 *
 * @property onlyCurrent If true, returns only data for the current library launch
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getNetworkStatistics(onlyCurrent: Boolean = false, extra: TdExtra =
        TdExtra.EMPTY): TdNetworkStatistics = exec(TdGetNetworkStatistics(onlyCurrent, extra))
