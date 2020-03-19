package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a supergroup or a channel by its identifier
 * This is an offline request if the current user is not a bot
 *
 * @property supergroupId Supergroup or channel identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getSupergroup(supergroupId: Int = 0, extra: TdExtra = TdExtra.EMPTY):
        TdSupergroup = exec(TdGetSupergroup(supergroupId, extra))
