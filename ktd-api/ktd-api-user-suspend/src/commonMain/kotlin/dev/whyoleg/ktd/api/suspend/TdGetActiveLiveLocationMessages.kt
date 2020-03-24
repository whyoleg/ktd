package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns all active live locations that should be updated by the client
 * The list is persistent across application restarts only if the message database is used
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getActiveLiveLocationMessages(extra: TdExtra = TdExtra.EMPTY):
        TdMessages = exec(TdGetActiveLiveLocationMessages(extra))
