package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns t.me URLs recently visited by a newly registered user
 *
 * @property referrer Google Play referrer to identify the user
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getRecentlyVisitedTMeUrls(referrer: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdTMeUrls = exec(TdGetRecentlyVisitedTMeUrls(referrer, extra))
