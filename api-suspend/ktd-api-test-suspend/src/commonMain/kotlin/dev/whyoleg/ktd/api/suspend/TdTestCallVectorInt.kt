package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the received vector of numbers
 * This is an offline method
 * Can be called before authorization
 *
 * @property x Vector of numbers to return
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.testCallVectorInt(x: IntArray = intArrayOf(), extra: TdExtra =
        TdExtra.EMPTY): TdTestVectorInt = exec(TdTestCallVectorInt(x, extra))
