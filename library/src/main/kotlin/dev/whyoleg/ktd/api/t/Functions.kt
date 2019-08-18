@file:Suppress("unused")

package dev.whyoleg.ktd.api.t

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns t.me URLs recently visited by a newly registered user
 */
suspend fun TelegramClient.t(
    f: GetRecentlyVisitedTMeUrls
): TMeUrls = execRaw(f) as TMeUrls
