package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns full information about a basic group by its identifier
 *
 * @property basicGroupId Basic group identifier
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getBasicGroupFullInfo(basicGroupId: Int = 0, extra: TdExtra =
        TdExtra.EMPTY): TdBasicGroupFullInfo = exec(TdGetBasicGroupFullInfo(basicGroupId, extra))
