package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns current verbosity level of the internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getLogVerbosityLevel(extra: TdExtra = TdExtra.EMPTY):
        TdLogVerbosityLevel = exec(TdGetLogVerbosityLevel(extra))
