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
 * Returns a list of installed sticker sets
 */
suspend fun TelegramClient.sticker(
    f: GetInstalledStickerSets
): StickerSets = exec(f) as StickerSets
