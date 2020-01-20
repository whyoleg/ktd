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
 * Returns information about a sticker set by its identifier
 */
suspend fun TelegramClient.sticker(
    f: GetStickerSet
): StickerSet = exec(f) as StickerSet
