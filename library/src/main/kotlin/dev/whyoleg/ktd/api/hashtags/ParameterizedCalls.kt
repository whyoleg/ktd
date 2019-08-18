@file:Suppress("unused")

package dev.whyoleg.ktd.api.hashtags

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Searches for recently used hashtags by their prefix
 *
 * @prefix - Hashtag prefix to search for
 * @limit - Maximum number of hashtags to be returned
 */
suspend fun TelegramClient.searchHashtags(
    prefix: String,
    limit: Int
): Hashtags = hashtags(
    SearchHashtags(
        prefix,
        limit
    )
)
