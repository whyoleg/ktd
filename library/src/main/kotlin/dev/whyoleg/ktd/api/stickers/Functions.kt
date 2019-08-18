@file:Suppress("unused")

package dev.whyoleg.ktd.api.stickers

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns stickers from the installed sticker sets that correspond to a given emoji. If the emoji is not empty, favorite and recently used stickers may also be returned
 */
suspend fun TelegramClient.stickers(
    f: GetStickers
): Stickers = execRaw(f) as Stickers

/**
 * Searches for stickers from public sticker sets that correspond to a given emoji
 */
suspend fun TelegramClient.stickers(
    f: SearchStickers
): Stickers = execRaw(f) as Stickers

/**
 * Returns a list of recently used stickers
 */
suspend fun TelegramClient.stickers(
    f: GetRecentStickers
): Stickers = execRaw(f) as Stickers

/**
 * Manually adds a new sticker to the list of recently used stickers. The new sticker is added to the top of the list. If the sticker was already in the list, it is removed from the list first. Only stickers belonging to a sticker set can be added to this list
 */
suspend fun TelegramClient.stickers(
    f: AddRecentSticker
): Stickers = execRaw(f) as Stickers

/**
 * Clears the list of recently used stickers
 */
suspend fun TelegramClient.stickers(
    f: ClearRecentStickers
): Ok = execRaw(f) as Ok

/**
 * Returns favorite stickers
 */
suspend fun TelegramClient.stickers(
    f: GetFavoriteStickers
): Stickers = execRaw(f) as Stickers
