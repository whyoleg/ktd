package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sets the verbosity level for a specified TDLib internal log tag
 * This is an offline method
 * Can be called before authorization
 *
 * @property tag Logging tag to change verbosity level
 * @property newVerbosityLevel New verbosity level
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setLogTagVerbosityLevel(
    tag: String? = null,
    newVerbosityLevel: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdSetLogTagVerbosityLevel(tag, newVerbosityLevel, extra))
