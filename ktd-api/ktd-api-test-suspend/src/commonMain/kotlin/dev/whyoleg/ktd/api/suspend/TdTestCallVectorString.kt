package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the received vector of strings
 * This is an offline method
 * Can be called before authorization
 *
 * @property x Vector of strings to return
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.testCallVectorString(x: List<String> = emptyList(), extra: TdExtra =
        TdExtra.EMPTY): TdTestVectorString = exec(TdTestCallVectorString(x, extra))
