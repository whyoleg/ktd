package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns list of proxies that are currently set up
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getProxies(extra: TdExtra = TdExtra.EMPTY): TdProxies =
        exec(TdGetProxies(extra))
