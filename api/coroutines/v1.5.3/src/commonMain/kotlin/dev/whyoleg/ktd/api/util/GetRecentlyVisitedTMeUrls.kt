@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.util

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns t.me URLs recently visited by a newly registered user
 *
 * @referrer - Google Play referrer to identify the user
 */
suspend fun TelegramClient.getRecentlyVisitedTMeUrls(
    referrer: String? = null
): TMeUrls = util(
    GetRecentlyVisitedTMeUrls(
        referrer
    )
)

/**
 * Returns t.me URLs recently visited by a newly registered user
 */
suspend fun TelegramClient.util(
    f: GetRecentlyVisitedTMeUrls
): TMeUrls = exec(f) as TMeUrls
