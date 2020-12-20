@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.sticker

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdGetStickers): TdStickers = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getStickers(emoji, limit)",
            "dev.whyoleg.ktd.api.suspend.getStickers"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getStickers(emoji: String? = null, limit: Int = 0): TdStickers =
        exec(TdGetStickers(emoji, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdSearchStickers): TdStickers = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchStickers(emoji, limit)",
            "dev.whyoleg.ktd.api.suspend.searchStickers"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchStickers(emoji: String? = null, limit: Int = 0): TdStickers =
        exec(TdSearchStickers(emoji, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdGetInstalledStickerSets): TdStickerSets = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getInstalledStickerSets(isMasks)",
            "dev.whyoleg.ktd.api.suspend.getInstalledStickerSets"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getInstalledStickerSets(isMasks: Boolean = false): TdStickerSets =
        exec(TdGetInstalledStickerSets(isMasks))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdGetArchivedStickerSets): TdStickerSets = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getArchivedStickerSets(isMasks, offsetStickerSetId, limit)",
            "dev.whyoleg.ktd.api.suspend.getArchivedStickerSets"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getArchivedStickerSets(
    isMasks: Boolean = false,
    offsetStickerSetId: Long = 0L,
    limit: Int = 0
): TdStickerSets = exec(TdGetArchivedStickerSets(isMasks, offsetStickerSetId, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdGetTrendingStickerSets): TdStickerSets = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getTrendingStickerSets()",
            "dev.whyoleg.ktd.api.suspend.getTrendingStickerSets"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getTrendingStickerSets(): TdStickerSets =
        exec(TdGetTrendingStickerSets())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdGetAttachedStickerSets): TdStickerSets = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getAttachedStickerSets(fileId)",
            "dev.whyoleg.ktd.api.suspend.getAttachedStickerSets"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getAttachedStickerSets(fileId: Int = 0): TdStickerSets =
        exec(TdGetAttachedStickerSets(fileId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdGetStickerSet): TdStickerSet = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getStickerSet(setId)", "dev.whyoleg.ktd.api.suspend.getStickerSet"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getStickerSet(setId: Long = 0L): TdStickerSet =
        exec(TdGetStickerSet(setId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdSearchStickerSet): TdStickerSet = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchStickerSet(name)",
            "dev.whyoleg.ktd.api.suspend.searchStickerSet"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchStickerSet(name: String? = null): TdStickerSet =
        exec(TdSearchStickerSet(name))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdSearchInstalledStickerSets): TdStickerSets = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchInstalledStickerSets(isMasks, query, limit)",
            "dev.whyoleg.ktd.api.suspend.searchInstalledStickerSets"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchInstalledStickerSets(
    isMasks: Boolean = false,
    query: String? = null,
    limit: Int = 0
): TdStickerSets = exec(TdSearchInstalledStickerSets(isMasks, query, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdSearchStickerSets): TdStickerSets = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchStickerSets(query)",
            "dev.whyoleg.ktd.api.suspend.searchStickerSets"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchStickerSets(query: String? = null): TdStickerSets =
        exec(TdSearchStickerSets(query))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdChangeStickerSet): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("changeStickerSet(setId, isInstalled, isArchived)",
            "dev.whyoleg.ktd.api.suspend.changeStickerSet"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.changeStickerSet(
    setId: Long = 0L,
    isInstalled: Boolean = false,
    isArchived: Boolean = false
): TdOk = exec(TdChangeStickerSet(setId, isInstalled, isArchived))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdViewTrendingStickerSets): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("viewTrendingStickerSets(stickerSetIds)",
            "dev.whyoleg.ktd.api.suspend.viewTrendingStickerSets"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.viewTrendingStickerSets(stickerSetIds: LongArray = longArrayOf()): TdOk =
        exec(TdViewTrendingStickerSets(stickerSetIds))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdReorderInstalledStickerSets): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("reorderInstalledStickerSets(isMasks, stickerSetIds)",
            "dev.whyoleg.ktd.api.suspend.reorderInstalledStickerSets"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.reorderInstalledStickerSets(isMasks: Boolean = false,
        stickerSetIds: LongArray = longArrayOf()): TdOk =
        exec(TdReorderInstalledStickerSets(isMasks, stickerSetIds))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdGetRecentStickers): TdStickers = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getRecentStickers(isAttached)",
            "dev.whyoleg.ktd.api.suspend.getRecentStickers"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getRecentStickers(isAttached: Boolean = false): TdStickers =
        exec(TdGetRecentStickers(isAttached))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdAddRecentSticker): TdStickers = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("addRecentSticker(isAttached, sticker)",
            "dev.whyoleg.ktd.api.suspend.addRecentSticker"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.addRecentSticker(isAttached: Boolean = false, sticker: TdInputFile? =
        null): TdStickers = exec(TdAddRecentSticker(isAttached, sticker))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdRemoveRecentSticker): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("removeRecentSticker(isAttached, sticker)",
            "dev.whyoleg.ktd.api.suspend.removeRecentSticker"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.removeRecentSticker(isAttached: Boolean = false, sticker: TdInputFile? =
        null): TdOk = exec(TdRemoveRecentSticker(isAttached, sticker))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdClearRecentStickers): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("clearRecentStickers(isAttached)",
            "dev.whyoleg.ktd.api.suspend.clearRecentStickers"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.clearRecentStickers(isAttached: Boolean = false): TdOk =
        exec(TdClearRecentStickers(isAttached))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdGetFavoriteStickers): TdStickers = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getFavoriteStickers()",
            "dev.whyoleg.ktd.api.suspend.getFavoriteStickers"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getFavoriteStickers(): TdStickers = exec(TdGetFavoriteStickers())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdAddFavoriteSticker): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("addFavoriteSticker(sticker)",
            "dev.whyoleg.ktd.api.suspend.addFavoriteSticker"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.addFavoriteSticker(sticker: TdInputFile? = null): TdOk =
        exec(TdAddFavoriteSticker(sticker))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdRemoveFavoriteSticker): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("removeFavoriteSticker(sticker)",
            "dev.whyoleg.ktd.api.suspend.removeFavoriteSticker"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.removeFavoriteSticker(sticker: TdInputFile? = null): TdOk =
        exec(TdRemoveFavoriteSticker(sticker))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdCreateNewStickerSet): TdStickerSet = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("createNewStickerSet(userId, title, name, isMasks, stickers)",
            "dev.whyoleg.ktd.api.suspend.createNewStickerSet"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.createNewStickerSet(
    userId: Int = 0,
    title: String? = null,
    name: String? = null,
    isMasks: Boolean = false,
    stickers: List<TdInputSticker> = emptyList()
): TdStickerSet = exec(TdCreateNewStickerSet(userId, title, name, isMasks, stickers))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdAddStickerToSet): TdStickerSet = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("addStickerToSet(userId, name, sticker)",
            "dev.whyoleg.ktd.api.suspend.addStickerToSet"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.addStickerToSet(
    userId: Int = 0,
    name: String? = null,
    sticker: TdInputSticker? = null
): TdStickerSet = exec(TdAddStickerToSet(userId, name, sticker))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdSetStickerPositionInSet): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setStickerPositionInSet(sticker, position)",
            "dev.whyoleg.ktd.api.suspend.setStickerPositionInSet"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setStickerPositionInSet(sticker: TdInputFile? = null, position: Int = 0):
        TdOk = exec(TdSetStickerPositionInSet(sticker, position))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sticker(f: TdRemoveStickerFromSet): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("removeStickerFromSet(sticker)",
            "dev.whyoleg.ktd.api.suspend.removeStickerFromSet"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.removeStickerFromSet(sticker: TdInputFile? = null): TdOk =
        exec(TdRemoveStickerFromSet(sticker))
