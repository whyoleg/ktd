package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Searches for stickers from public sticker sets that correspond to a given emoji
 *
 * @property emoji String representation of emoji
 * @property limit The maximum number of stickers to be returned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.searchStickers(
    emoji: String? = null,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdStickers = exec(TdSearchStickers(emoji, limit, extra))
