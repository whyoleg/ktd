package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches for recently used hashtags by their prefix
 *
 * @property prefix Hashtag prefix to search for
 * @property limit The maximum number of hashtags to be returned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchHashtags(
    prefix: String? = null,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdHashtags = exec(TdSearchHashtags(prefix, limit, extra))
