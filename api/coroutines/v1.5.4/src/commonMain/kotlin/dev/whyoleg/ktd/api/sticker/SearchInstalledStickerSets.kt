@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.sticker

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Searches for installed sticker sets by looking for specified query in their title and name
 *
 * @isMasks - Pass true to return mask sticker sets
 *            Pass false to return ordinary sticker sets
 * @query - Query to search for
 * @limit - Maximum number of sticker sets to return
 */
suspend fun TelegramClient.searchInstalledStickerSets(
    isMasks: Boolean = false,
    query: String? = null,
    limit: Int = 0
): StickerSets = sticker(
    SearchInstalledStickerSets(
        isMasks,
        query,
        limit
    )
)

/**
 * Searches for installed sticker sets by looking for specified query in their title and name
 */
suspend fun TelegramClient.sticker(
    f: SearchInstalledStickerSets
): StickerSets = exec(f) as StickerSets
