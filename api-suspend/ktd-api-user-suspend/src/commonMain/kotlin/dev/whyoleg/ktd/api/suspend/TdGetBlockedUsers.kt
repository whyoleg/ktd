package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns users that were blocked by the current user
 *
 * @property offset Number of users to skip in the result
 * @property limit The maximum number of users to return
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getBlockedUsers(
    offset: Int = 0,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdUsers = exec(TdGetBlockedUsers(offset, limit, extra))
