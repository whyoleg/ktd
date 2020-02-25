package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Disconnects all websites from the current user's Telegram account
 *
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.disconnectAllWebsites(extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdDisconnectAllWebsites(extra))
