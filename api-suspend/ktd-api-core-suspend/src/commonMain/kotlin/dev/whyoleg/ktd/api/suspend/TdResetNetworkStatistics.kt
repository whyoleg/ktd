package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Resets all network data usage statistics to zero
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.resetNetworkStatistics(extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdResetNetworkStatistics(extra))
