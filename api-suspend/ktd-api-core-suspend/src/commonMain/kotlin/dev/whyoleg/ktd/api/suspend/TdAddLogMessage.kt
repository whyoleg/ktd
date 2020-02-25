package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds a message to TDLib internal log
 * This is an offline method
 * Can be called before authorization
 *
 * @property verbosityLevel The minimum verbosity level needed for the message to be logged, 0-1023
 * @property text Text of a message to log
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.addLogMessage(
    verbosityLevel: Int = 0,
    text: String? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdOk = exec(TdAddLogMessage(verbosityLevel, text, extra))
