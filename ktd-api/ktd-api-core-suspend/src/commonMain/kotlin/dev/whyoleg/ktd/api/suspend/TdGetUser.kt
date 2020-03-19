package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a user by their identifier
 * This is an offline request if the current user is not a bot
 *
 * @property userId User identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getUser(userId: Int = 0, extra: TdExtra = TdExtra.EMPTY): TdUser =
        exec(TdGetUser(userId, extra))
