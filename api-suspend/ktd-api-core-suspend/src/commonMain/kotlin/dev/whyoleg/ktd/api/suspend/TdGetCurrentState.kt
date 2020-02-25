package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns all updates needed to restore current TDLib state, i.e
 * All actual UpdateAuthorizationState/UpdateUser/UpdateNewChat and others
 * This is especially useful if TDLib is run in a separate process
 * This is an offline method
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getCurrentState(extra: TdExtra = TdExtra.EMPTY): TdUpdates =
        exec(TdGetCurrentState(extra))
