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
 * Changes the order of installed sticker sets
 */
suspend fun TelegramClient.sticker(
    f: ReorderInstalledStickerSets
): Ok = exec(f) as Ok
