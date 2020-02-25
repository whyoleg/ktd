package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Does nothing
 * This is an offline method
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.testCallEmpty(extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdTestCallEmpty(extra))
