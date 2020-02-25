package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns the received bytes
 * This is an offline method
 * Can be called before authorization
 *
 * @property x Bytes to return
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.testCallBytes(x: ByteArray = byteArrayOf(), extra: TdExtra =
        TdExtra.EMPTY): TdTestBytes = exec(TdTestCallBytes(x, extra))
