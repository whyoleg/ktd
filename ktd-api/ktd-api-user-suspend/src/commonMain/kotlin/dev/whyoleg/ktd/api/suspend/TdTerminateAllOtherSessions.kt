package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Terminates all other sessions of the current user
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.terminateAllOtherSessions(extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdTerminateAllOtherSessions(extra))
