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
 *
 * @emoji - String representation of emoji
 *          If empty, returns all known installed stickers
 * @limit - Maximum number of stickers to be returned
 */
suspend fun TelegramClient.getStickers(
    emoji: String? = null,
    limit: Int = 0
): Stickers = sticker(
    GetStickers(
        emoji,
        limit
    )
)

/**
 * Searches for stickers from public sticker sets that correspond to a given emoji
 *
 * @emoji - String representation of emoji
 * @limit - Maximum number of stickers to be returned
 */
suspend fun TelegramClient.searchStickers(
    emoji: String? = null,
    limit: Int = 0
): Stickers = sticker(
    SearchStickers(
        emoji,
        limit
    )
)

/**
 * Returns a list of installed sticker sets
 *
 * @isMasks - Pass true to return mask sticker sets
 *            Pass false to return ordinary sticker sets
 */
suspend fun TelegramClient.getInstalledStickerSets(
    isMasks: Boolean = false
): StickerSets = sticker(
    GetInstalledStickerSets(
        isMasks
    )
)

/**
 * Returns a list of archived sticker sets
 *
 * @isMasks - Pass true to return mask stickers sets
 *            Pass false to return ordinary sticker sets
 * @offsetStickerSetId - Identifier of the sticker set from which to return the result
 * @limit - Maximum number of sticker sets to return
 */
suspend fun TelegramClient.getArchivedStickerSets(
    isMasks: Boolean = false,
    offsetStickerSetId: Long = 0L,
    limit: Int = 0
): StickerSets = sticker(
    GetArchivedStickerSets(
        isMasks,
        offsetStickerSetId,
        limit
    )
)

/**
 * Returns a list of trending sticker sets
 */
suspend fun TelegramClient.getTrendingStickerSets(): StickerSets = sticker(
    GetTrendingStickerSets()
)

/**
 * Returns a list of sticker sets attached to a file
 * Currently only photos and videos can have attached sticker sets
 *
 * @fileId - File identifier
 */
suspend fun TelegramClient.getAttachedStickerSets(
    fileId: Int = 0
): StickerSets = sticker(
    GetAttachedStickerSets(
        fileId
    )
)

/**
 * Returns information about a sticker set by its identifier
 *
 * @setId - Identifier of the sticker set
 */
suspend fun TelegramClient.getStickerSet(
    setId: Long = 0L
): StickerSet = sticker(
    GetStickerSet(
        setId
    )
)

/**
 * Searches for a sticker set by its name
 *
 * @name - Name of the sticker set
 */
suspend fun TelegramClient.searchStickerSet(
    name: String? = null
): StickerSet = sticker(
    SearchStickerSet(
        name
    )
)

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
 * Installs/uninstalls or activates/archives a sticker set
 *
 * @setId - Identifier of the sticker set
 * @isInstalled - The new value of is_installed
 * @isArchived - The new value of is_archived
 *               A sticker set can't be installed and archived simultaneously
 */
suspend fun TelegramClient.changeStickerSet(
    setId: Long = 0L,
    isInstalled: Boolean = false,
    isArchived: Boolean = false
): Ok = sticker(
    ChangeStickerSet(
        setId,
        isInstalled,
        isArchived
    )
)

/**
 * Informs the server that some trending sticker sets have been viewed by the user
 *
 * @stickerSetIds - Identifiers of viewed trending sticker sets
 */
suspend fun TelegramClient.viewTrendingStickerSets(
    stickerSetIds: LongArray = longArrayOf()
): Ok = sticker(
    ViewTrendingStickerSets(
        stickerSetIds
    )
)

/**
 * Changes the order of installed sticker sets
 *
 * @isMasks - Pass true to change the order of mask sticker sets
 *            Pass false to change the order of ordinary sticker sets
 * @stickerSetIds - Identifiers of installed sticker sets in the new correct order
 */
suspend fun TelegramClient.reorderInstalledStickerSets(
    isMasks: Boolean = false,
    stickerSetIds: LongArray = longArrayOf()
): Ok = sticker(
    ReorderInstalledStickerSets(
        isMasks,
        stickerSetIds
    )
)

/**
 * Returns a list of recently used stickers
 *
 * @isAttached - Pass true to return stickers and masks that were recently attached to photos or video files
 *               Pass false to return recently sent stickers
 */
suspend fun TelegramClient.getRecentStickers(
    isAttached: Boolean = false
): Stickers = sticker(
    GetRecentStickers(
        isAttached
    )
)

/**
 * Manually adds a new sticker to the list of recently used stickers
 * The new sticker is added to the top of the list
 * If the sticker was already in the list, it is removed from the list first
 * Only stickers belonging to a sticker set can be added to this list
 *
 * @isAttached - Pass true to add the sticker to the list of stickers recently attached to photo or video files
 *               Pass false to add the sticker to the list of recently sent stickers
 * @sticker - Sticker file to add
 */
suspend fun TelegramClient.addRecentSticker(
    isAttached: Boolean = false,
    sticker: InputFile? = null
): Stickers = sticker(
    AddRecentSticker(
        isAttached,
        sticker
    )
)

/**
 * Removes a sticker from the list of recently used stickers
 *
 * @isAttached - Pass true to remove the sticker from the list of stickers recently attached to photo or video files
 *               Pass false to remove the sticker from the list of recently sent stickers
 * @sticker - Sticker file to delete
 */
suspend fun TelegramClient.removeRecentSticker(
    isAttached: Boolean = false,
    sticker: InputFile? = null
): Ok = sticker(
    RemoveRecentSticker(
        isAttached,
        sticker
    )
)

/**
 * Clears the list of recently used stickers
 *
 * @isAttached - Pass true to clear the list of stickers recently attached to photo or video files
 *               Pass false to clear the list of recently sent stickers
 */
suspend fun TelegramClient.clearRecentStickers(
    isAttached: Boolean = false
): Ok = sticker(
    ClearRecentStickers(
        isAttached
    )
)

/**
 * Returns favorite stickers
 */
suspend fun TelegramClient.getFavoriteStickers(): Stickers = sticker(
    GetFavoriteStickers()
)

/**
 * Adds a new sticker to the list of favorite stickers
 * The new sticker is added to the top of the list
 * If the sticker was already in the list, it is removed from the list first
 * Only stickers belonging to a sticker set can be added to this list
 *
 * @sticker - Sticker file to add
 */
suspend fun TelegramClient.addFavoriteSticker(
    sticker: InputFile? = null
): Ok = sticker(
    AddFavoriteSticker(
        sticker
    )
)

/**
 * Removes a sticker from the list of favorite stickers
 *
 * @sticker - Sticker file to delete from the list
 */
suspend fun TelegramClient.removeFavoriteSticker(
    sticker: InputFile? = null
): Ok = sticker(
    RemoveFavoriteSticker(
        sticker
    )
)

/**
 * Creates a new sticker set
 * Returns the newly created sticker set
 *
 * @userId - Sticker set owner
 * @title - Sticker set title
 * @name - Sticker set name
 *         Can contain only English letters, digits and underscores
 *         Must end with *"_by_<bot username>"* (*<bot_username>* is case insensitive)
 * @isMasks - True, if stickers are masks
 * @stickers - List of stickers to be added to the set
 */
@BotsOnly
suspend fun TelegramClient.createNewStickerSet(
    userId: Int = 0,
    title: String? = null,
    name: String? = null,
    isMasks: Boolean = false,
    stickers: Array<InputSticker> = emptyArray()
): StickerSet = sticker(
    CreateNewStickerSet(
        userId,
        title,
        name,
        isMasks,
        stickers
    )
)

/**
 * Adds a new sticker to a set
 * Returns the sticker set
 *
 * @userId - Sticker set owner
 * @name - Sticker set name
 * @sticker - Sticker to add to the set
 */
@BotsOnly
suspend fun TelegramClient.addStickerToSet(
    userId: Int = 0,
    name: String? = null,
    sticker: InputSticker? = null
): StickerSet = sticker(
    AddStickerToSet(
        userId,
        name,
        sticker
    )
)

/**
 * Changes the position of a sticker in the set to which it belongs
 * The sticker set must have been created by the bot
 *
 * @sticker - Sticker
 * @position - New position of the sticker in the set, zero-based
 */
@BotsOnly
suspend fun TelegramClient.setStickerPositionInSet(
    sticker: InputFile? = null,
    position: Int = 0
): Ok = sticker(
    SetStickerPositionInSet(
        sticker,
        position
    )
)

/**
 * Removes a sticker from the set to which it belongs
 * The sticker set must have been created by the bot
 *
 * @sticker - Sticker
 */
@BotsOnly
suspend fun TelegramClient.removeStickerFromSet(
    sticker: InputFile? = null
): Ok = sticker(
    RemoveStickerFromSet(
        sticker
    )
)
