package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the squared received number
 * This is an offline method
 * Can be called before authorization
 *
 * @property x Number to square
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.testSquareInt(x: Int = 0, extra: TdExtra = TdExtra.EMPTY): TdTestInt =
        exec(TdTestSquareInt(x, extra))
