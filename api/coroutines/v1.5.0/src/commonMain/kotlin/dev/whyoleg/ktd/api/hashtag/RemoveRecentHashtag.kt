@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.hashtag

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Removes a hashtag from the list of recently used hashtags
 *
 * @hashtag - Hashtag to delete
 */
suspend fun TelegramClient.removeRecentHashtag(
    hashtag: String? = null
): Ok = hashtag(
    RemoveRecentHashtag(
        hashtag
    )
)

/**
 * Removes a hashtag from the list of recently used hashtags
 */
suspend fun TelegramClient.hashtag(
    f: RemoveRecentHashtag
): Ok = exec(f) as Ok
