@file:Suppress("unused")

package dev.whyoleg.ktd.api.sticker

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a list of installed sticker sets
 */
suspend fun TelegramClient.sticker(
    f: GetInstalledStickerSets
): StickerSets = execRaw(f) as StickerSets

/**
 * Returns a list of archived sticker sets
 */
suspend fun TelegramClient.sticker(
    f: GetArchivedStickerSets
): StickerSets = execRaw(f) as StickerSets

/**
 * Returns a list of trending sticker sets
 */
suspend fun TelegramClient.sticker(
    f: GetTrendingStickerSets
): StickerSets = execRaw(f) as StickerSets

/**
 * Returns a list of sticker sets attached to a file. Currently only photos and videos can have attached sticker sets
 */
suspend fun TelegramClient.sticker(
    f: GetAttachedStickerSets
): StickerSets = execRaw(f) as StickerSets

/**
 * Returns information about a sticker set by its identifier
 */
suspend fun TelegramClient.sticker(
    f: GetStickerSet
): StickerSet = execRaw(f) as StickerSet

/**
 * Searches for a sticker set by its name
 */
suspend fun TelegramClient.sticker(
    f: SearchStickerSet
): StickerSet = execRaw(f) as StickerSet

/**
 * Searches for installed sticker sets by looking for specified query in their title and name
 */
suspend fun TelegramClient.sticker(
    f: SearchInstalledStickerSets
): StickerSets = execRaw(f) as StickerSets

/**
 * Searches for ordinary sticker sets by looking for specified query in their title and name. Excludes installed sticker sets from the results
 */
suspend fun TelegramClient.sticker(
    f: SearchStickerSets
): StickerSets = execRaw(f) as StickerSets

/**
 * Installs/uninstalls or activates/archives a sticker set
 */
suspend fun TelegramClient.sticker(
    f: ChangeStickerSet
): Ok = execRaw(f) as Ok

/**
 * Informs the server that some trending sticker sets have been viewed by the user
 */
suspend fun TelegramClient.sticker(
    f: ViewTrendingStickerSets
): Ok = execRaw(f) as Ok

/**
 * Changes the order of installed sticker sets
 */
suspend fun TelegramClient.sticker(
    f: ReorderInstalledStickerSets
): Ok = execRaw(f) as Ok

/**
 * Removes a sticker from the list of recently used stickers
 */
suspend fun TelegramClient.sticker(
    f: RemoveRecentSticker
): Ok = execRaw(f) as Ok

/**
 * Adds a new sticker to the list of favorite stickers. The new sticker is added to the top of the list. If the sticker was already in the list, it is removed from the list first. Only stickers belonging to a sticker set can be added to this list
 */
suspend fun TelegramClient.sticker(
    f: AddFavoriteSticker
): Ok = execRaw(f) as Ok

/**
 * Removes a sticker from the list of favorite stickers
 */
suspend fun TelegramClient.sticker(
    f: RemoveFavoriteSticker
): Ok = execRaw(f) as Ok

/**
 * Creates a new sticker set; for bots only. Returns the newly created sticker set
 */
suspend fun TelegramClient.sticker(
    f: CreateNewStickerSet
): StickerSet = execRaw(f) as StickerSet

/**
 * Adds a new sticker to a set; for bots only. Returns the sticker set
 */
suspend fun TelegramClient.sticker(
    f: AddStickerToSet
): StickerSet = execRaw(f) as StickerSet

/**
 * Changes the position of a sticker in the set to which it belongs; for bots only. The sticker set must have been created by the bot
 */
suspend fun TelegramClient.sticker(
    f: SetStickerPositionInSet
): Ok = execRaw(f) as Ok

/**
 * Removes a sticker from the set to which it belongs; for bots only. The sticker set must have been created by the bot
 */
suspend fun TelegramClient.sticker(
    f: RemoveStickerFromSet
): Ok = execRaw(f) as Ok
