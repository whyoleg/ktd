package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns stickers from the installed sticker sets that correspond to a given emoji
 * If the emoji is not empty, favorite and recently used stickers may also be returned
 *
 * @property emoji String representation of emoji
 *                 If empty, returns all known installed stickers
 * @property limit The maximum number of stickers to be returned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getStickers(
    emoji: String? = null,
    limit: Int = 0,
    extra: TdExtra = TdExtra.EMPTY
): TdStickers = exec(TdGetStickers(emoji, limit, extra))
