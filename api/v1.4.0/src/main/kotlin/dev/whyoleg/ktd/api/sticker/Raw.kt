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
 * Returns stickers from the installed sticker sets that correspond to a given emoji
 * If the emoji is not empty, favorite and recently used stickers may also be returned
 */
suspend fun TelegramClient.sticker(
    f: GetStickers
): Stickers = exec(f) as Stickers

/**
 * Searches for stickers from public sticker sets that correspond to a given emoji
 */
suspend fun TelegramClient.sticker(
    f: SearchStickers
): Stickers = exec(f) as Stickers

/**
 * Returns a list of installed sticker sets
 */
suspend fun TelegramClient.sticker(
    f: GetInstalledStickerSets
): StickerSets = exec(f) as StickerSets

/**
 * Returns a list of archived sticker sets
 */
suspend fun TelegramClient.sticker(
    f: GetArchivedStickerSets
): StickerSets = exec(f) as StickerSets

/**
 * Returns a list of trending sticker sets
 */
suspend fun TelegramClient.sticker(
    f: GetTrendingStickerSets
): StickerSets = exec(f) as StickerSets

/**
 * Returns a list of sticker sets attached to a file
 * Currently only photos and videos can have attached sticker sets
 */
suspend fun TelegramClient.sticker(
    f: GetAttachedStickerSets
): StickerSets = exec(f) as StickerSets

/**
 * Returns information about a sticker set by its identifier
 */
suspend fun TelegramClient.sticker(
    f: GetStickerSet
): StickerSet = exec(f) as StickerSet

/**
 * Searches for a sticker set by its name
 */
suspend fun TelegramClient.sticker(
    f: SearchStickerSet
): StickerSet = exec(f) as StickerSet

/**
 * Searches for installed sticker sets by looking for specified query in their title and name
 */
suspend fun TelegramClient.sticker(
    f: SearchInstalledStickerSets
): StickerSets = exec(f) as StickerSets

/**
 * Searches for ordinary sticker sets by looking for specified query in their title and name
 * Excludes installed sticker sets from the results
 */
suspend fun TelegramClient.sticker(
    f: SearchStickerSets
): StickerSets = exec(f) as StickerSets

/**
 * Installs/uninstalls or activates/archives a sticker set
 */
suspend fun TelegramClient.sticker(
    f: ChangeStickerSet
): Ok = exec(f) as Ok

/**
 * Informs the server that some trending sticker sets have been viewed by the user
 */
suspend fun TelegramClient.sticker(
    f: ViewTrendingStickerSets
): Ok = exec(f) as Ok

/**
 * Changes the order of installed sticker sets
 */
suspend fun TelegramClient.sticker(
    f: ReorderInstalledStickerSets
): Ok = exec(f) as Ok

/**
 * Returns a list of recently used stickers
 */
suspend fun TelegramClient.sticker(
    f: GetRecentStickers
): Stickers = exec(f) as Stickers

/**
 * Manually adds a new sticker to the list of recently used stickers
 * The new sticker is added to the top of the list
 * If the sticker was already in the list, it is removed from the list first
 * Only stickers belonging to a sticker set can be added to this list
 */
suspend fun TelegramClient.sticker(
    f: AddRecentSticker
): Stickers = exec(f) as Stickers

/**
 * Removes a sticker from the list of recently used stickers
 */
suspend fun TelegramClient.sticker(
    f: RemoveRecentSticker
): Ok = exec(f) as Ok

/**
 * Clears the list of recently used stickers
 */
suspend fun TelegramClient.sticker(
    f: ClearRecentStickers
): Ok = exec(f) as Ok

/**
 * Returns favorite stickers
 */
suspend fun TelegramClient.sticker(
    f: GetFavoriteStickers
): Stickers = exec(f) as Stickers

/**
 * Adds a new sticker to the list of favorite stickers
 * The new sticker is added to the top of the list
 * If the sticker was already in the list, it is removed from the list first
 * Only stickers belonging to a sticker set can be added to this list
 */
suspend fun TelegramClient.sticker(
    f: AddFavoriteSticker
): Ok = exec(f) as Ok

/**
 * Removes a sticker from the list of favorite stickers
 */
suspend fun TelegramClient.sticker(
    f: RemoveFavoriteSticker
): Ok = exec(f) as Ok

/**
 * Returns emoji corresponding to a sticker
 */
suspend fun TelegramClient.sticker(
    f: GetStickerEmojis
): StickerEmojis = exec(f) as StickerEmojis

/**
 * Creates a new sticker set
 * Returns the newly created sticker set
 */
@BotsOnly
suspend fun TelegramClient.sticker(
    f: CreateNewStickerSet
): StickerSet = exec(f) as StickerSet

/**
 * Adds a new sticker to a set
 * Returns the sticker set
 */
@BotsOnly
suspend fun TelegramClient.sticker(
    f: AddStickerToSet
): StickerSet = exec(f) as StickerSet

/**
 * Changes the position of a sticker in the set to which it belongs
 * The sticker set must have been created by the bot
 */
@BotsOnly
suspend fun TelegramClient.sticker(
    f: SetStickerPositionInSet
): Ok = exec(f) as Ok

/**
 * Removes a sticker from the set to which it belongs
 * The sticker set must have been created by the bot
 */
@BotsOnly
suspend fun TelegramClient.sticker(
    f: RemoveStickerFromSet
): Ok = exec(f) as Ok
