package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sets the current network type
 * Can be called before authorization
 * Calling this method forces all network connections to reopen, mitigating the delay in switching between different networks, so it should be called whenever the network is changed, even if the network type remains the same
 * Network type is used to check whether the library can use the network at all and also for collecting detailed network data usage statistics
 *
 * @property type The new network type
 *                By default, networkTypeOther
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setNetworkType(type: TdNetworkType? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdSetNetworkType(type, extra))
