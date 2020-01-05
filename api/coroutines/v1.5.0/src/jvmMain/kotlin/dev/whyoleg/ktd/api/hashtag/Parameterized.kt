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
 * Searches for recently used hashtags by their prefix
 *
 * @prefix - Hashtag prefix to search for
 * @limit - Maximum number of hashtags to be returned
 */
suspend fun TelegramClient.searchHashtags(
    prefix: String? = null,
    limit: Int = 0
): Hashtags = hashtag(
    SearchHashtags(
        prefix,
        limit
    )
)

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
