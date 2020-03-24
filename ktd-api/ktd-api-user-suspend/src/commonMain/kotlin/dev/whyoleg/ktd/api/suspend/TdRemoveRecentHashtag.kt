package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Removes a hashtag from the list of recently used hashtags
 *
 * @property hashtag Hashtag to delete
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.removeRecentHashtag(hashtag: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdRemoveRecentHashtag(hashtag, extra))
