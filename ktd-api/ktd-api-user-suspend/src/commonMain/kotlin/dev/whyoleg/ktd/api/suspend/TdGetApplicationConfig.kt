package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns application config, provided by the server
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getApplicationConfig(extra: TdExtra = TdExtra.EMPTY): TdJsonValue =
        exec(TdGetApplicationConfig(extra))
