package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes a user from the blacklist
 *
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.unblockUser(userId: Int = 0, extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdUnblockUser(userId, extra))
