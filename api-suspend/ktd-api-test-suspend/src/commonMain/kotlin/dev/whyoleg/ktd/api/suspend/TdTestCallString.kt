package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the received string
 * This is an offline method
 * Can be called before authorization
 *
 * @property x String to return
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.testCallString(x: String? = null, extra: TdExtra = TdExtra.EMPTY):
        TdTestString = exec(TdTestCallString(x, extra))
