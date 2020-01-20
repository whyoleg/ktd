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
 * Returns a list of sticker sets attached to a file
 * Currently only photos and videos can have attached sticker sets
 */
suspend fun TelegramClient.sticker(
    f: GetAttachedStickerSets
): StickerSets = exec(f) as StickerSets
