package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns all active sessions of the current user
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getActiveSessions(extra: TdExtra = TdExtra.EMPTY): TdSessions =
        exec(TdGetActiveSessions(extra))
