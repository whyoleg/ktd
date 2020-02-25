package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about currently used log stream for internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getLogStream(extra: TdExtra = TdExtra.EMPTY): TdLogStream =
        exec(TdGetLogStream(extra))
