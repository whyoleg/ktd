package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns full information about a supergroup or a channel by its identifier, cached for up to 1 minute
 *
 * @property supergroupId Supergroup or channel identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getSupergroupFullInfo(supergroupId: Int = 0, extra: TdExtra =
        TdExtra.EMPTY): TdSupergroupFullInfo = exec(TdGetSupergroupFullInfo(supergroupId, extra))
