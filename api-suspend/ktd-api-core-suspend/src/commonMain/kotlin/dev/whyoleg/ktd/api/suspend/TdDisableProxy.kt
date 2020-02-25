package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Disables the currently enabled proxy
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.disableProxy(extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdDisableProxy(extra))
