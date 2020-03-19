package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Disconnects website from the current user's Telegram account
 *
 * @property websiteId Website identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.disconnectWebsite(websiteId: Long = 0L, extra: TdExtra = TdExtra.EMPTY):
        TdOk = exec(TdDisconnectWebsite(websiteId, extra))
