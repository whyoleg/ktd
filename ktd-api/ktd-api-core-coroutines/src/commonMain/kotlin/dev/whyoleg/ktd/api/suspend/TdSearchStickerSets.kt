package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches for ordinary sticker sets by looking for specified query in their title and name
 * Excludes installed sticker sets from the results
 *
 * @property query Query to search for
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchStickerSets(query: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdStickerSets = exec(TdSearchStickerSets(query, extra))
