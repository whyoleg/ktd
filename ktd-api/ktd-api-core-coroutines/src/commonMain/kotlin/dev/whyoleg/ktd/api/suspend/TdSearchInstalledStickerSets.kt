package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches for installed sticker sets by looking for specified query in their title and name
 *
 * @property isMasks Pass true to return mask sticker sets
 *                   Pass false to return ordinary sticker sets
 * @property query Query to search for
 * @property limit The maximum number of sticker sets to return
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchInstalledStickerSets(
    isMasks: Boolean = false,
    query: String? = null,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdStickerSets = exec(TdSearchInstalledStickerSets(isMasks, query, limit, extra))
