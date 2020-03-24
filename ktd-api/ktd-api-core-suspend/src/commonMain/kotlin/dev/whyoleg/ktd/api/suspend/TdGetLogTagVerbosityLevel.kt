package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns current verbosity level for a specified TDLib internal log tag
 * This is an offline method
 * Can be called before authorization
 *
 * @property tag Logging tag to change verbosity level
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getLogTagVerbosityLevel(tag: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdLogVerbosityLevel = exec(TdGetLogTagVerbosityLevel(tag, extra))
