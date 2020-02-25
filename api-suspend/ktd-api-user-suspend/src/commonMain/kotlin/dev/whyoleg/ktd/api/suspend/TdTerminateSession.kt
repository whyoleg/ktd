package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Terminates a session of the current user
 *
 * @property sessionId Session identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.terminateSession(sessionId: Long = 0L, extra: TdExtra = TdExtra.EMPTY):
        TdOk = exec(TdTerminateSession(sessionId, extra))
