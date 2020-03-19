package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sets the verbosity level of the internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 *
 * @property newVerbosityLevel New value of the verbosity level for logging
 *                             Value 0 corresponds to fatal errors, value 1 corresponds to errors, value 2 corresponds to warnings and debug warnings, value 3 corresponds to informational, value 4 corresponds to debug, value 5 corresponds to verbose debug, value greater than 5 and up to 1023 can be used to enable even more logging
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setLogVerbosityLevel(newVerbosityLevel: Int = 0, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdSetLogVerbosityLevel(newVerbosityLevel, extra))
