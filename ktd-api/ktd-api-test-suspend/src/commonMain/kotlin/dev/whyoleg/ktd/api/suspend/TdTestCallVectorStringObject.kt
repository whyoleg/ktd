package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the received vector of objects containing a string
 * This is an offline method
 * Can be called before authorization
 *
 * @property x Vector of objects to return
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.testCallVectorStringObject(x: List<TdTestString> = emptyList(),
        extra: TdExtra = TdExtra.EMPTY): TdTestVectorStringObject =
        exec(TdTestCallVectorStringObject(x, extra))
