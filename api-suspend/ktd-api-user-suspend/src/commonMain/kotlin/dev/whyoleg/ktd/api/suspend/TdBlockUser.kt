package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Adds a user to the blacklist
 *
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.blockUser(userId: Int = 0, extra: TdExtra = TdExtra.EMPTY): TdOk =
        exec(TdBlockUser(userId, extra))
