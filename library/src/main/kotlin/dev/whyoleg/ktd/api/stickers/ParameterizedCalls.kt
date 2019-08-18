@file:Suppress("unused")

package dev.whyoleg.ktd.api.stickers

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns stickers from the installed sticker sets that correspond to a given emoji. If the emoji is not empty, favorite and recently used stickers may also be returned
 *
 * @emoji - String representation of emoji. If empty, returns all known installed stickers
 * @limit - Maximum number of stickers to be returned
 */
suspend fun TelegramClient.getStickers(
    emoji: String,
    limit: Int
): Stickers = stickers(
    GetStickers(
        emoji,
        limit
    )
)

/**
 * Searches for stickers from public sticker sets that correspond to a given emoji
 *
 * @emoji - String representation of emoji; must be non-empty
 * @limit - Maximum number of stickers to be returned
 */
suspend fun TelegramClient.searchStickers(
    emoji: String,
    limit: Int
): Stickers = stickers(
    SearchStickers(
        emoji,
        limit
    )
)

/**
 * Returns a list of recently used stickers
 *
 * @isAttached - Pass true to return stickers and masks that were recently attached to photos or video files; pass false to return recently sent stickers
 */
suspend fun TelegramClient.getRecentStickers(
    isAttached: Boolean
): Stickers = stickers(
    GetRecentStickers(
        isAttached
    )
)

/**
 * Manually adds a new sticker to the list of recently used stickers. The new sticker is added to the top of the list. If the sticker was already in the list, it is removed from the list first. Only stickers belonging to a sticker set can be added to this list
 *
 * @isAttached - Pass true to add the sticker to the list of stickers recently attached to photo or video files; pass false to add the sticker to the list of recently sent stickers
 * @sticker - Sticker file to add
 */
suspend fun TelegramClient.addRecentSticker(
    isAttached: Boolean,
    sticker: InputFile
): Stickers = stickers(
    AddRecentSticker(
        isAttached,
        sticker
    )
)

/**
 * Clears the list of recently used stickers
 *
 * @isAttached - Pass true to clear the list of stickers recently attached to photo or video files; pass false to clear the list of recently sent stickers
 */
suspend fun TelegramClient.clearRecentStickers(
    isAttached: Boolean
): Ok = stickers(
    ClearRecentStickers(
        isAttached
    )
)

/**
 * Returns favorite stickers
 */
suspend fun TelegramClient.getFavoriteStickers(): Stickers = stickers(
    GetFavoriteStickers()
)
