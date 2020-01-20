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
 * Searches for ordinary sticker sets by looking for specified query in their title and name
 * Excludes installed sticker sets from the results
 *
 * @query - Query to search for
 */
suspend fun TelegramClient.searchStickerSets(
    query: String? = null
): StickerSets = sticker(
    SearchStickerSets(
        query
    )
)

/**
 * Searches for ordinary sticker sets by looking for specified query in their title and name
 * Excludes installed sticker sets from the results
 */
suspend fun TelegramClient.sticker(
    f: SearchStickerSets
): StickerSets = exec(f) as StickerSets
