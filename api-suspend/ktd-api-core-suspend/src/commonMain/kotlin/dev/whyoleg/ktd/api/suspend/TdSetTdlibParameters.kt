package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Sets the parameters for TDLib initialization
 * Works only when the current authorization state is authorizationStateWaitTdlibParameters
 *
 * @property parameters Parameters
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.setTdlibParameters(parameters: TdTdlibParameters? = null, extra: TdExtra
        = TdExtra.EMPTY): TdOk = exec(TdSetTdlibParameters(parameters, extra))
