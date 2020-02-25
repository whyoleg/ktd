package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a basic group by its identifier
 * This is an offline request if the current user is not a bot
 *
 * @property basicGroupId Basic group identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getBasicGroup(basicGroupId: Int = 0, extra: TdExtra = TdExtra.EMPTY):
        TdBasicGroup = exec(TdGetBasicGroup(basicGroupId, extra))
