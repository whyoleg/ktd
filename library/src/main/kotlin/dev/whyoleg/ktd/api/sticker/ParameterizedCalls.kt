@file:Suppress("unused")

package dev.whyoleg.ktd.api.sticker

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns a list of installed sticker sets
 *
 * @isMasks - Pass true to return mask sticker sets; pass false to return ordinary sticker sets
 */
suspend fun TelegramClient.getInstalledStickerSets(
    isMasks: Boolean
): StickerSets = sticker(
    GetInstalledStickerSets(
        isMasks
    )
)

/**
 * Returns a list of archived sticker sets
 *
 * @isMasks - Pass true to return mask stickers sets; pass false to return ordinary sticker sets
 * @offsetStickerSetId - Identifier of the sticker set from which to return the result
 * @limit - Maximum number of sticker sets to return
 */
suspend fun TelegramClient.getArchivedStickerSets(
    isMasks: Boolean,
    offsetStickerSetId: Long,
    limit: Int
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
 * Returns a list of sticker sets attached to a file. Currently only photos and videos can have attached sticker sets
 *
 * @fileId - File identifier
 */
suspend fun TelegramClient.getAttachedStickerSets(
    fileId: Int
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
    setId: Long
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
    name: String
): StickerSet = sticker(
    SearchStickerSet(
        name
    )
)

/**
 * Searches for installed sticker sets by looking for specified query in their title and name
 *
 * @isMasks - Pass true to return mask sticker sets; pass false to return ordinary sticker sets
 * @query - Query to search for
 * @limit - Maximum number of sticker sets to return
 */
suspend fun TelegramClient.searchInstalledStickerSets(
    isMasks: Boolean,
    query: String,
    limit: Int
): StickerSets = sticker(
    SearchInstalledStickerSets(
        isMasks,
        query,
        limit
    )
)

/**
 * Searches for ordinary sticker sets by looking for specified query in their title and name. Excludes installed sticker sets from the results
 *
 * @query - Query to search for
 */
suspend fun TelegramClient.searchStickerSets(
    query: String
): StickerSets = sticker(
    SearchStickerSets(
        query
    )
)

/**
 * Installs/uninstalls or activates/archives a sticker set
 *
 * @setId - Identifier of the sticker set
 * @isInstalled - The new value of isInstalled
 * @isArchived - The new value of isArchived. A sticker set can't be installed and archived simultaneously
 */
suspend fun TelegramClient.changeStickerSet(
    setId: Long,
    isInstalled: Boolean,
    isArchived: Boolean
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
    stickerSetIds: LongArray
): Ok = sticker(
    ViewTrendingStickerSets(
        stickerSetIds
    )
)

/**
 * Changes the order of installed sticker sets
 *
 * @isMasks - Pass true to change the order of mask sticker sets; pass false to change the order of ordinary sticker sets
 * @stickerSetIds - Identifiers of installed sticker sets in the new correct order
 */
suspend fun TelegramClient.reorderInstalledStickerSets(
    isMasks: Boolean,
    stickerSetIds: LongArray
): Ok = sticker(
    ReorderInstalledStickerSets(
        isMasks,
        stickerSetIds
    )
)

/**
 * Removes a sticker from the list of recently used stickers
 *
 * @isAttached - Pass true to remove the sticker from the list of stickers recently attached to photo or video files; pass false to remove the sticker from the list of recently sent stickers
 * @sticker - Sticker file to delete
 */
suspend fun TelegramClient.removeRecentSticker(
    isAttached: Boolean,
    sticker: InputFile
): Ok = sticker(
    RemoveRecentSticker(
        isAttached,
        sticker
    )
)

/**
 * Adds a new sticker to the list of favorite stickers. The new sticker is added to the top of the list. If the sticker was already in the list, it is removed from the list first. Only stickers belonging to a sticker set can be added to this list
 *
 * @sticker - Sticker file to add
 */
suspend fun TelegramClient.addFavoriteSticker(
    sticker: InputFile
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
    sticker: InputFile
): Ok = sticker(
    RemoveFavoriteSticker(
        sticker
    )
)

/**
 * Creates a new sticker set; for bots only. Returns the newly created sticker set
 *
 * @userId - Sticker set owner
 * @title - Sticker set title; 1-64 characters
 * @name - Sticker set name. Can contain only English letters, digits and underscores. Must end with *"_by_<bot username>"* (*<bot_username>* is case insensitive); 1-64 characters
 * @isMasks - True, if stickers are masks
 * @stickers - List of stickers to be added to the set
 */
suspend fun TelegramClient.createNewStickerSet(
    userId: Int,
    title: String,
    name: String,
    isMasks: Boolean,
    stickers: Array<InputSticker>
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
 * Adds a new sticker to a set; for bots only. Returns the sticker set
 *
 * @userId - Sticker set owner
 * @name - Sticker set name
 * @sticker - Sticker to add to the set
 */
suspend fun TelegramClient.addStickerToSet(
    userId: Int,
    name: String,
    sticker: InputSticker
): StickerSet = sticker(
    AddStickerToSet(
        userId,
        name,
        sticker
    )
)

/**
 * Changes the position of a sticker in the set to which it belongs; for bots only. The sticker set must have been created by the bot
 *
 * @sticker - Sticker
 * @position - New position of the sticker in the set, zero-based
 */
suspend fun TelegramClient.setStickerPositionInSet(
    sticker: InputFile,
    position: Int
): Ok = sticker(
    SetStickerPositionInSet(
        sticker,
        position
    )
)

/**
 * Removes a sticker from the set to which it belongs; for bots only. The sticker set must have been created by the bot
 *
 * @sticker - Sticker
 */
suspend fun TelegramClient.removeStickerFromSet(
    sticker: InputFile
): Ok = sticker(
    RemoveStickerFromSet(
        sticker
    )
)
