@file:Suppress("unused")

package dev.whyoleg.ktd.api.t

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns t.me URLs recently visited by a newly registered user
 *
 * @referrer - Google Play referrer to identify the user
 */
suspend fun TelegramClient.getRecentlyVisitedTMeUrls(
    referrer: String
): TMeUrls = t(
    GetRecentlyVisitedTMeUrls(
        referrer
    )
)
