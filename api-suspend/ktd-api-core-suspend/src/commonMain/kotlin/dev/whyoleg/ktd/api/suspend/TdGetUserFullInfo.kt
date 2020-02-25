package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns full information about a user by their identifier
 *
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getUserFullInfo(userId: Int = 0, extra: TdExtra = TdExtra.EMPTY):
        TdUserFullInfo = exec(TdGetUserFullInfo(userId, extra))
