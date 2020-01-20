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
 * Returns a list of archived sticker sets
 */
suspend fun TelegramClient.sticker(
    f: GetArchivedStickerSets
): StickerSets = exec(f) as StickerSets
